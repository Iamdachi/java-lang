package CJ2.Ch1.Streams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountLongWords {
    public CountLongWords() {
        String contents = Files.readString(Path.of("alice.txt"));
        /// Read file into string
        List<String> words = List.of(contents.split("\\PL+"));
        /// Split into words; nonletters are delimiters
        int count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }

        /// With streams, the same operation looks like this:
        long count2 = words.stream()
                .filter(w -> w.length() > 12)
                .count();

        /// do the filtering and counting in parallel
        long count3 = words.parallelStream()
                .filter(w -> w.length() > 12)
                .count();
    }
}
