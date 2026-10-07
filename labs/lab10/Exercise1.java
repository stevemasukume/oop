/*
 * Question from the lab manual:
 * Basic: Write a program that saves five lines typed by the user to a file and then reads them back.
 */
package lab10;
import java.nio.file.*;
import java.util.*;
public class Exercise1 {
    // Explanation: Files.write persists the lines, readAllLines loads them, and the finally-style cleanup removes the temporary file.
    public static void main(String[] args)throws Exception{Path file=Path.of("students-lab10.txt");List<String> lines=List.of("Tariro","Farai","Rudo","Kuda","Nyasha");Files.write(file,lines);Files.readAllLines(file).forEach(System.out::println);Files.deleteIfExists(file);}
}

