package CJ2.Ch1.Streams;

import java.math.BigInteger;
import java.util.stream.Stream;

public class CreatingStreams {
    public void main() {
        String contents = "somebigexampleofstrings"
        Stream<String> words = Stream.of(contents.split("\\PL+"));

        Stream<String> song = Stream.of("gently", "down", "the");

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,
                n -> n.add(BigInteger.ONE));
    }
}
