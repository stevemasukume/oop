import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LibraryDemo {
    public static void main(String[] args) throws Exception {
        Path data = Path.of(args.length == 0 ? "library-data" : args[0]);
        if (args.length > 0 && "--demo".equals(args[0])) data = Path.of("library-demo-data");
        if ("--demo".equals(args.length > 0 ? args[0] : "")) runDemo(data);
        else new LibraryMenu(new Library(data)).run();
    }

    private static void runDemo(Path data) throws Exception {
        deleteIfExists(data);
        Library library = new Library(data);
        library.addItem(new Book("B1", "Effective Java", "Joshua Bloch"));
        library.addItem(new Dvd("D1", "Java Fundamentals", 90));
        library.registerMember(new Member("M1", "Ada Lovelace"));
        library.borrow("M1", "B1");
        System.out.println("Search 'java': " + library.searchByTitle("java"));
        System.out.println("Loans: " + library.getLoans());
        library.returnItem("B1");
        library.save();
        Library reloaded = new Library(data);
        System.out.println("Reloaded items: " + reloaded.getItems().size() + ", members: " + reloaded.getMembers().size());
        System.out.println("Demo completed; CSV data saved to " + data.toAbsolutePath());
    }
    private static void deleteIfExists(Path dir) throws IOException {
        if (Files.exists(dir)) try (java.util.stream.Stream<Path> paths = Files.walk(dir)) {
            paths.sorted(java.util.Comparator.reverseOrder()).forEach(p -> { try { Files.delete(p); } catch (IOException e) { throw new RuntimeException(e); } });
        }
    }
}
