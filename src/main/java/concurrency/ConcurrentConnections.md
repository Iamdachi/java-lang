### Concurrent Collections (ConcurrentHashMap)
Use Case: Reusing worker threads to process asynchronous tasks on shared in-memory state (e.g., local token 
caches, rate limit counter tracking) without locking the entire collection.

```java
// Thread-safe map using fine-grained segment/bucket locking internally
Map<String, Integer> rateLimitMap = new ConcurrentHashMap<>();

// Atomic compute operation prevents race conditions on parallel updates
rateLimitMap.compute(userKey, (key, count) -> count == null ? 1 : count + 1);
```


### Concurrent Collections (ArrayBlockingQueue)
Use Case: In-memory Producer-Consumer patterns (e.g., decoupling HTTP request ingestion from background processing)
where a fixed-capacity buffer applies natural backpressure when downstream workers are overloaded.

```java
BlockingQueue<OrderEvent> queue = new ArrayBlockingQueue<>(1000);

// Producer Thread: Blocks if the queue reaches capacity limit (1000)
queue.put(new OrderEvent("PAYMENT_SUCCESS"));

// Consumer Thread: Blocks until an item becomes available
OrderEvent event = queue.take();
```