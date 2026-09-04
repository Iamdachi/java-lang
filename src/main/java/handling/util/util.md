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

