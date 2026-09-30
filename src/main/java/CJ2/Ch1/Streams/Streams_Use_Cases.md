
Mapping Database Entities to Frontend DTOs.
```java
public List<UserResponseDto> getActiveUsers() {
    return userRepository.findAll().stream()
        .filter(User::isActive)                          // Keep active users
        .map(user -> new UserResponseDto(user.getId(), user.getName())) // Transform to DTO
        .collect(Collectors.toList());                  // Collect into a List
}
```
Grouping orders by status and summing total revenue.
```java
Map<OrderStatus, Double> totalRevenueByStatus = orders.stream()
    .collect(Collectors.groupingBy(
        Order::getStatus,
        Collectors.summingDouble(Order::getTotalAmount)
    ));
```


Extracting unique email domains from a list of user profiles.
```java
Set<String> uniqueDomains = users.stream()
    .map(User::getEmail)
    .filter(Objects::nonNull)
    .map(email -> email.substring(email.indexOf("@") + 1))
    .collect(Collectors.toSet());
```

Extracting ERROR-level logs from an application log file.
```java
try (Stream<String> lines = Files.lines(Paths.get("app.log"))) {
    List<String> errorLogs = lines
        .filter(line -> line.contains("ERROR"))
        .limit(100)
        .collect(Collectors.toList());
}
```

Calculating complex risk scores across thousands of financial portfolios simultaneously.
```java
List<RiskScore> scores = portfolios.parallelStream()
    .map(riskEngine::calculateScore)
    .collect(Collectors.toList());
```
