import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final LibraryItem item;
    private final Member member;
    private final LocalDate borrowedOn;
    private final LocalDate dueOn;
    private LocalDate returnedOn;

    public Loan(LibraryItem item, Member member, LocalDate borrowedOn) {
        this.item = Objects.requireNonNull(item);
        this.member = Objects.requireNonNull(member);
        this.borrowedOn = Objects.requireNonNull(borrowedOn);
        this.dueOn = borrowedOn.plusDays(item.loanPeriodDays());
    }

    public LibraryItem getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getBorrowedOn() { return borrowedOn; }
    public LocalDate getDueOn() { return dueOn; }
    public LocalDate getReturnedOn() { return returnedOn; }
    public boolean isReturned() { return returnedOn != null; }
    public boolean isOverdue(LocalDate date) { return !isReturned() && dueOn.isBefore(date); }
    void markReturned(LocalDate date) { returnedOn = Objects.requireNonNull(date); }

    @Override
    public String toString() {
        return "Loan{item='" + item.getTitle() + "', member='" + member.getName()
                + "', borrowedOn=" + borrowedOn + ", dueOn=" + dueOn
                + (isReturned() ? ", returnedOn=" + returnedOn : "") + "}";
    }
}
