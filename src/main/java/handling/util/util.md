### Functional Interface
Functional interface is an interface that contains exactly one abstract method.  
  
Abstract method - method declared with a signature(name, return type and parameters),
but no implementation(body).  
  
Interface - enforces what an implementing class must do, not how it does. Its methods
are implicitly abstract and public. Enables a class to implement multiple interfaces 
(implements A, B), bypassing Java's single class inheritance restriction.

Abstract Class - cannot be instantiated directly and servses as a partially implemented blueprint.
Extended using single class.
Enables a class to implement multiple interfaces (implements A, B), bypassing Java's single class inheritance restriction.

Difference Abstract class V Interface    
AC defines an "IS-A" identity (e.g., Dog IS-AN Animal).  
Defines a "CAN-DO" capability (e.g., Dog CAN-BE Runnable).


### Comparator
Functional interface used to compare two objects.


### Optional

Container for an object that can be null.
under the hood:
```java
    public boolean isPresent() { return value != null;}
    private Optional(T value) {this.value = value;}
```

### Function

Function<T, R> is a functional interface that accepts argument of type T
and returns result of type R. Core method is R apply(T t) that executes the transformation.
  
Mostly Used for mapping/converting data from one type or format to another (e.g., transforming an entity into a DTO).

### Supplier
Supplier<T> is a functional interface that takes no arguments and returns type T value.
Core Method is T get() that generates or retrieves an instance when invoked.  

Used for lazy evaluation, factory patterns, or deferred execution (e.g., generating values only when needed).  

