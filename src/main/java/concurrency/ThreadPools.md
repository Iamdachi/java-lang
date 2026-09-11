### Thread Pools (ExecutorService)
Use Case: Reusing worker threads to process asynchronous tasks  

```java
// Create a bounded pool of 10 threads
ExecutorService executor = Executors.newFixedThreadPool(10);

// Submit async tasks without blocking the main execution path
executor.submit(() -> processOrderNotification(orderId));

// Graceful shutdown during application termination
executor.shutdown();
```

