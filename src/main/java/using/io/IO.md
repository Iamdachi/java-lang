# Using Java IO

## Core interfaces
- InputStream
- OutputStream
- Reader
- Writer

*Stream are for binary data(images, raw bytes, network payloads)
Reader/Writer classes are for text data. Those come down to char, byte, char[] and byte[].

## Byte Streams
FileInputStream / FileOutputStream — read/write raw bytes to/from a file
BufferedInputStream / BufferedOutputStream — wraps another stream to add buffering (fewer actual disk/network calls, much faster)
ByteArrayInputStream / ByteArrayOutputStream — read/write bytes to an in-memory array instead of a file — useful for tests or in-memory processing
DataInputStream / DataOutputStream — read/write primitive types (int, double, etc.) in binary form, useful for custom binary protocols
ObjectInputStream / ObjectOutputStream — Java serialization (reading/writing whole objects) — rare in modern prod code due to security/versioning issues, but you'll see it in legacy systems

## Character Streams
FileReader / FileWriter — read/write text files (uses default charset unless you specify one — a common bug source)
InputStreamReader / OutputStreamWriter — the bridge between byte streams and character streams; lets you specify an explicit charset (e.g., UTF-8). This is the "correct" way to read text from a byte source.
BufferedReader / BufferedWriter — buffered text I/O; BufferedReader gives you the very useful readLine() method
PrintWriter — convenient formatted text output (println, printf); commonly used for writing to files or wrapping System.out
StringReader / StringWriter — read/write text to/from an in-memory String

## Other notable pieces
File — represents a file/directory path (metadata: exists, size, delete, rename) — does not do I/O itself. Largely superseded by java.nio.file.Path in modern code.
RandomAccessFile — lets you read/write at arbitrary positions in a file (seek), rather than sequentially — used for things like custom file formats or database-like storage
Closeable / AutoCloseable — interfaces that let a resource be used in try-with-resources (try (...) { }), which auto-closes it — virtually every I/O class you use should be wrapped this way to avoid leaks
Serializable — marker interface for objects that can be used with ObjectOutputStream

## Real world patterns
Reading a whole file:
Writing a whole file:
Streaming large files line-by-line (memory-safe):
Reading from an HTTP response / any InputStream as text:
Copying a file:
Copying a stream (e.g. download to disk):
Reading resources from classpath (config, templates):
Temp files:
Walking a directory:
JSON/CSV/binary formats: almost never hand-rolled with java.io — use Jackson, Gson, Apache Commons CSV, Protobuf, etc. java.io/nio just supplies the underlying stream.
