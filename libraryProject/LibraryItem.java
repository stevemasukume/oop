import java.util.Objects;

public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;
    private Library library;

    protected LibraryItem(String id, String title) {
        this.id = requireText(id, "id");
        this.title = requireText(title, "title");
    }

    public abstract int loanPeriodDays();

    public final String getId() { return id; }
    public final String getTitle() { return title; }
    public final boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }
    void attachTo(Library library) { this.library = library; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (library == null) throw new IllegalStateException("Item is not registered with a library");
        library.borrowItem(this, member);
    }

    @Override
    public void giveBack() { setAvailable(true); }

    static String requireText(String value, String name) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " must not be blank");
        }
        return value.trim();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title
                + "', loanPeriodDays=" + loanPeriodDays() + ", available=" + available + "}";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof LibraryItem && id.equals(((LibraryItem) other).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
