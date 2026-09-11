### LoggerFactory
Manufactures: Logger instances.
Static lookup factory for SLF4J. It discovers the underlying logging framework (Logback, Log4j2) 
on the classpath and binds requested Logger instances to that implementation.

```java
Logger log = LoggerFactory.getLogger(MyService.class);
```

The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various 
logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the 
desired logging framework at deployment time. It is a de facto standard in Boot development.

### DocumentBuilderFactory
Manufactures: DocumentBuilder instances (for DOM XML parsing).

```java
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
```