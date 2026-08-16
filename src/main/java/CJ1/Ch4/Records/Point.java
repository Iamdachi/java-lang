package CJ1.Ch4.Records;

/**
 * canonical constructor - sets all instance fields
 */
record Point(double x, double y) { }

record CustomPoint(double x, double y)
{
    /**
     * custom constructor - The first statement of such a
     * constructor must call another constructor, so that ultimately the canonical
     * constructor is invoked.
     */
    public CustomPoint() { this(0, 0); }
}

/**
 * If the canonical constructor needs to do additional work, you can provide
 * your own implementation
 */
record Range(int from, int to)
{
    public Range(int from, int to)
    {
        if (from <= to)
        {
            this.from = from;
            this.to = to;
        }
        else
        {
            this.from = to;
            this.to = from;
        }
    }
}

/**
you are encouraged to use a compact form when implementing the
canonical constructor. You don’t specify the parameter list:
*/
record Range2(int from, int to)
{
    public Range2 // Compact form
    {
        if (from > to) // Swap the bounds
        {
            int temp = from;
            from = to;
            to = temp;
        }
    }
}