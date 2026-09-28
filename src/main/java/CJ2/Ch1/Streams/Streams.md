## Definition and Collections
Streams are like collections. With stream you specify what you want to have done,
not how to do it.

For example, you want to compute average of some property. You specify the source of the
data and stream library then optimizes the computation, for example by using multiple threads...

A stream seems superficially similar to a collection,
allowing you to transform and retrieve data. But there are
significant differences:
1. A stream does not store its elements. They may be
   stored in an underlying collection or generated on
   demand.
2. Stream operations don't mutate their source. For
   example, the filter method does not remove elements
   from a stream but yields a new stream in which they
   are not present.
3. Stream operations are lazy when possible. This means
   they are not executed until their result is needed. For
   example, if you only ask for the first five long words
   instead of all, the filter method will stop filtering after
   the fifth match. As a consequence, you can even have
   infinite streams!

## Transformations
A stream transformation produces a stream whose elements are derived from
those of another stream.  

filter  
map  
flatMap  
mapMulti  

## Reductions
Reductions are terminal operations. They reduce the stream to a
nonstream value that can be used in your program.

count  
max  
min  
findFirst  
findAny  
anyMatch  
allMatch  
noneMatch  

```java

```