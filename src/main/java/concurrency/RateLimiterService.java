package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


// @Component
public class RateLimiterService {
    // IP address : their count (Thread safe)
    private final ConcurrentHashMap<String, AtomicInteger> requestCounts = new ConcurrentHashMap<>();

    public boolean allowRequest(String clientIp) {
        AtomicInteger count = requestCounts.computeIfAbsent(clientIp, k -> new AtomicInteger(0));
        int currentCount = count.incrementAndGet();
        return currentCount <= 10;
    }

    // Called every minute by @Scheduled task to flush old windows
    public void resetCounts() {
        requestCounts.clear();
    }
}
