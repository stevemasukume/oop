import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();
    private final Path dataDirectory;

    public Library(Path dataDirectory) throws IOException {
        this.dataDirectory = Objects.requireNonNull(dataDirectory);
        Files.createDirectories(dataDirectory);
        load();
    }

    public void addItem(LibraryItem item) {
        Objects.requireNonNull(item);
        if (items.putIfAbsent(item.getId(), item) != null) throw new IllegalArgumentException("Duplicate item id");
        item.attachTo(this);
    }
    public void registerMember(Member member) {
        Objects.requireNonNull(member);
        if (members.putIfAbsent(member.getId(), member) != null) throw new IllegalArgumentException("Duplicate member id");
    }
    public LibraryItem getItem(String id) { return items.get(id); }
    public Member getMember(String id) { return members.get(id); }
    public List<LibraryItem> getItems() { return items.values().stream().sorted(Comparator.comparing(LibraryItem::getId)).collect(Collectors.toList()); }
    public List<Member> getMembers() { return members.values().stream().sorted(Comparator.comparing(Member::getId)).collect(Collectors.toList()); }
    public List<Loan> getLoans() { return List.copyOf(loans); }

    public void borrow(String memberId, String itemId) throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = requireMember(memberId);
        LibraryItem item = requireItem(itemId);
        item.borrow(member);
    }

    public void returnItem(String itemId) {
        LibraryItem item = requireItem(itemId);
        Loan loan = loans.stream().filter(l -> l.getItem().equals(item) && !l.isReturned()).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item is not currently borrowed"));
        loan.markReturned(LocalDate.now());
        item.giveBack();
        loan.getMember().removeLoan(loan);
    }

    public List<LibraryItem> searchByTitle(String text) {
        String query = LibraryItem.requireText(text, "search text").toLowerCase();
        return items.values().stream().filter(i -> i.getTitle().toLowerCase().contains(query))
                .sorted(Comparator.comparing(LibraryItem::getTitle)).collect(Collectors.toList());
    }
    public List<Loan> overdueLoans() {
        return loans.stream().filter(l -> l.isOverdue(LocalDate.now()))
                .sorted(Comparator.comparing(Loan::getDueOn)).collect(Collectors.toList());
    }

    void borrowItem(LibraryItem item, Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!item.isAvailable()) throw new ItemNotAvailableException("Item is already borrowed: " + item.getId());
        Loan loan = new Loan(item, member, LocalDate.now());
        member.addLoan(loan);
        loans.add(loan);
        item.setAvailable(false);
    }

    private Member requireMember(String id) { Member m = members.get(id); if (m == null) throw new IllegalArgumentException("Unknown member: " + id); return m; }
    private LibraryItem requireItem(String id) { LibraryItem i = items.get(id); if (i == null) throw new IllegalArgumentException("Unknown item: " + id); return i; }

    public void save() throws IOException {
        write("items.csv", "type,id,title,authorOrDuration", items.values().stream().map(i ->
                i instanceof Book ? csv("BOOK", i.getId(), i.getTitle(), ((Book)i).getAuthor())
                : csv("DVD", i.getId(), i.getTitle(), Integer.toString(((Dvd)i).getDurationMinutes()))).collect(Collectors.toList()));
        write("members.csv", "id,name", members.values().stream().map(m -> csv(m.getId(), m.getName())).collect(Collectors.toList()));
        write("loans.csv", "itemId,memberId,borrowedOn,returnedOn", loans.stream().map(l ->
                csv(l.getItem().getId(), l.getMember().getId(), l.getBorrowedOn().toString(),
                        l.getReturnedOn() == null ? "" : l.getReturnedOn().toString())).collect(Collectors.toList()));
    }

    private void load() throws IOException {
        Path itemFile = dataDirectory.resolve("items.csv");
        if (Files.exists(itemFile)) for (String[] row : read(itemFile)) {
            if ("BOOK".equals(row[0])) addItem(new Book(row[1], row[2], row[3]));
            else if ("DVD".equals(row[0])) addItem(new Dvd(row[1], row[2], Integer.parseInt(row[3])));
        }
        Path memberFile = dataDirectory.resolve("members.csv");
        if (Files.exists(memberFile)) for (String[] row : read(memberFile)) registerMember(new Member(row[0], row[1]));
        Path loanFile = dataDirectory.resolve("loans.csv");
        if (Files.exists(loanFile)) for (String[] row : read(loanFile)) {
            if (row.length < 3) continue;
            Loan loan = new Loan(requireItem(row[0]), requireMember(row[1]), LocalDate.parse(row[2]));
            if (!requireItem(row[0]).isAvailable()) throw new IOException("Duplicate active loan for item " + row[0]);
            if (row.length > 3 && !row[3].isEmpty()) loan.markReturned(LocalDate.parse(row[3]));
            else {
                loan.getItem().setAvailable(false);
                try { loan.getMember().addLoan(loan); }
                catch (MemberLimitExceededException e) { throw new IOException(e.getMessage(), e); }
            }
            loans.add(loan);
        }
    }

    private void write(String name, String header, List<String> rows) throws IOException {
        try (BufferedWriter out = Files.newBufferedWriter(dataDirectory.resolve(name), StandardCharsets.UTF_8)) {
            out.write(header); out.newLine(); for (String row : rows) { out.write(row); out.newLine(); }
        }
    }
    private static List<String[]> read(Path file) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            return in.lines().skip(1).filter(s -> !s.isBlank()).map(Library::parse).collect(Collectors.toList());
        }
    }
    private static String csv(String... values) { return java.util.Arrays.stream(values).map(v -> "\"" + v.replace("\"", "\"\"") + "\"").collect(Collectors.joining(",")); }
    private static String[] parse(String line) { List<String> values = new ArrayList<>(); StringBuilder value = new StringBuilder(); boolean quoted = false; for (int i=0;i<line.length();i++) { char c=line.charAt(i); if(c=='\"'){ if(quoted && i+1<line.length() && line.charAt(i+1)=='\"'){value.append('\"');i++;} else quoted=!quoted; } else if(c==','&&!quoted){values.add(value.toString());value.setLength(0);} else value.append(c); } values.add(value.toString()); return values.toArray(new String[0]); }

}
