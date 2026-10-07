public class Book extends LibraryItem {
    private final String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = requireText(author, "author");
    }

    public String getAuthor() { return author; }
    @Override public int loanPeriodDays() { return 21; }
}
