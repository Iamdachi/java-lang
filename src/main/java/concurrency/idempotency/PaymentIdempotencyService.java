package concurrency.idempotency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

//@Service
public class PaymentIdempotencyService {

    private final ConcurrentHashMap<String, CompletableFuture<PaymentResult>> inFlight =
            new ConcurrentHashMap<>();

    private final PaymentProcessor paymentProcessor;

    public PaymentIdempotencyService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    /**
     * putIfAbsent is the atomic check-and-insert — two threads racing on the same key can't both start a charge.
     */
    public PaymentResult process(String idempotencyKey, PaymentRequest request) {
        CompletableFuture<PaymentResult> future = new CompletableFuture<>();
        CompletableFuture<PaymentResult> existing = inFlight.putIfAbsent(idempotencyKey, future);

        if (existing != null) {
            // another thread is already processing this key — just wait on its result
            return existing.join();
        }

        try {
            PaymentResult result = paymentProcessor.charge(request);
            future.complete(result);
            return result;
        } catch (Exception e) {
            future.completeExceptionally(e);
            throw e;
        } finally {
            inFlight.remove(idempotencyKey);
        }
    }
}
