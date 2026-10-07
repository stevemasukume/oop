import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;
    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        this.id = LibraryItem.requireText(id, "member id");
        this.name = LibraryItem.requireText(name, "member name");
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    void addLoan(Loan loan) throws MemberLimitExceededException {
        if (loans.size() >= MAX_LOANS) {
            throw new MemberLimitExceededException("Member " + id + " already has " + MAX_LOANS + " loans");
        }
        loans.add(loan);
    }

    void removeLoan(Loan loan) { loans.remove(loan); }

    @Override
    public String toString() {
        return "Member{id='" + id + "', name='" + name + "', activeLoans=" + loans.size() + "}";
    }
}
