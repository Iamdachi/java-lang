# How to handle JSON data?

You essentially never write manual JSON parsing code in idiomatic Spring — the framework and Jackson do it declaratively through annotations and type binding.

Spring/Jackson handles serialization/deserialization transparently at the HTTP boundary.

## Use Records
Records are the idiomatic DTO choice (Java 16+). Immutable, concise, and Jackson supports them out of the box — no boilerplate getters/setters/constructors needed.

The direct mapping, both directions

```java
record UserDto(String name, int age) {}

// JSON → record
UserDto user = objectMapper.readValue(json, UserDto.class);

// record → JSON
String json = objectMapper.writeValueAsString(user);
```

## Jackson ObjectMapper
ObjectMapper is Jackson's core class — it's the actual engine that does JSON ↔ Java object conversion
Think of ObjectMapper as the JSON equivalent of BufferedReader/InputStreamReader.
it converts JSON text ↔ Java objects (via reflection over your class's fields/constructors/accessors, or record components)