import java.io.IOException;
import java.util.Scanner;

public class LibraryMenu {
    private final Library library;
    private final Scanner input = new Scanner(System.in);
    public LibraryMenu(Library library) { this.library = library; }

    public void run() throws IOException {
        boolean running = true;
        while (running) {
            System.out.println("\n1 Add item  2 Register member  3 Borrow  4 Return  5 Overdue  6 Search  7 List  0 Save and exit");
            try {
                switch (input.nextLine().trim()) {
                    case "1": addItem(); break;
                    case "2": library.registerMember(new Member(ask("Member id"), ask("Name"))); break;
                    case "3": library.borrow(ask("Member id"), ask("Item id")); break;
                    case "4": library.returnItem(ask("Item id")); break;
                    case "5": library.overdueLoans().forEach(System.out::println); break;
                    case "6": library.searchByTitle(ask("Title")).forEach(System.out::println); break;
                    case "7": library.getItems().forEach(System.out::println); break;
                    case "0": library.save(); running = false; break;
                    default: System.out.println("Choose a listed option.");
                }
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        }
    }
    private void addItem() {
        String type = ask("Book or DVD").toUpperCase();
        String id = ask("Item id"); String title = ask("Title");
        if ("BOOK".equals(type)) library.addItem(new Book(id, title, ask("Author")));
        else if ("DVD".equals(type)) library.addItem(new Dvd(id, title, Integer.parseInt(ask("Duration minutes"))));
        else throw new IllegalArgumentException("Type must be Book or DVD");
    }
    private String ask(String prompt) { System.out.print(prompt + ": "); return input.nextLine(); }
}
