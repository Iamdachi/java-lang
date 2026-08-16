A record is a special form of a class whose state is immutable and readable  by the public.
The instance fields of a record are called its components.
Every record has three methods defined automatically: toString, equals, and hashCode.

Use a record instead of a class for immutable data that is completely
represented by a set of variables. Use a class if the data is mutable, or if the
representation may evolve over time. Records are easier to read, more
efficient, and safer in concurrent programs.