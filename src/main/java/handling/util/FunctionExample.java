package handling.util;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> parse = Integer::parseInt;
        Function<Integer, Integer> doubleIt = x -> x * 2;

        // Chains execution: parses string first, then doubles the result
        Function<String, Integer> parseAndDouble = parse.andThen(doubleIt);
        Integer result = parseAndDouble.apply("10"); // 20
    }
}
