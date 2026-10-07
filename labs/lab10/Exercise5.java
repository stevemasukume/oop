/*
 * Question from the lab manual:
 * Exercise: Handle a missing file with a specific NoSuchFileException catch block.
 */
package lab10;
public class Exercise5 {
    // Explanation: Catching NoSuchFileException separately gives a precise response for the expected missing-file case.
    public static void main(String[] args){try{java.nio.file.Files.readAllLines(java.nio.file.Path.of("does-not-exist.txt"));}catch(java.nio.file.NoSuchFileException e){System.out.println("Missing file handled safely.");}catch(java.io.IOException e){System.out.println("I/O error: "+e.getMessage());}}
}

