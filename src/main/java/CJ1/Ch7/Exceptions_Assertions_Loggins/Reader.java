package CJ1.Ch7.Exceptions_Assertions_Loggins;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * util.Scanner parses primitive types and strings using regex. Its slow.
 * It is not often used in prod. It is used mainly for
 *  reading stdin, CLI utilities, early prototypes before refactoring
 *
 */
public class Reader {
    Scanner readFile(File sourceFile) throws FileNotFoundException {
        return new Scanner(sourceFile);
    }

    String readData(Scanner in) throws EOFException {
        throw new EOFException();
    }

    Closeable myCLoseable;
}
