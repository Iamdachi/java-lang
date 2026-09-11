package concurrency.idempotency;

//@RestController
//@RequestMapping("/payments")
public class PaymentController {

    private final PaymentIdempotencyService idempotencyService;

    public PaymentController(PaymentIdempotencyService idempotencyService) {
        this.idempotencyService = idempotencyService;
    }

    /**
     * An idempotency key is a unique ID the client generates and sends with a request (e.g. a UUID),
     * so retries of the "same" request are recognized as duplicates instead of being processed again.
     */
    //@PostMapping
    public ResponseEntity<PaymentResult> charge(
            //@RequestHeader("Idempotency-Key") String key,
            //@RequestBody PaymentRequest request
    ){
        return ResponseEntity.ok(idempotencyService.process(key, request));
    }
}
