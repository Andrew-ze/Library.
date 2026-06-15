import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }
    // returns confirmation of added book
    public String addBook(Book bk) {
        books.add(bk);
        return "- " + bk.getTitle();
    }
    // returns confirmation of registered member
    public String registerMember(Member mmb) {
        members.add(mmb);
        return "- " + mmb.getName();
    }

    // returns result of lending attempt
    public String lendBook(String isbn, String memberId) {
        Book book = findBook(isbn);
        Member member = findMember(memberId);

        if (book == null) return "Book not found.";
        if (member == null) return "Member not found.";
        if (!book.isAvailable())
            return "Rejected:" + book.getTitle() + " " + "is already borrowed.";

        Loan loan = new Loan(member, book);
        book.setAvailable(false);
        member.addLoan(loan);
        return "Success: " + loan;
    }

    // returns result of return attempt
    public String returnBook(String isbn, String memberId) {
        Member member = findMember(memberId);
        if (member == null) return "Member not found.";

        Loan found = null;
        for (Loan l : member.getLoans()) {
            if (l.getBook().getIsbn().equals(isbn)) {
                found = l;
                break;
            }
        }

        if (found == null)
            return "No loan record found for this book.";

        found.getBook().setAvailable(true);
        member.removeLoan(found);
        return found.getBook().getTitle() + " returned by " + member.getName();
    }

    // returns search results as a string
    public String searchByTitle(String keyword) {
        StringBuilder result = new StringBuilder("Search results for: " + keyword + "\n");
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                result.append("  ").append(b).append("\n");
        }
        return result.toString();
    }

    // returns full library status as a string
    public String getState() {
        StringBuilder sb = new StringBuilder("\n     Library Status     \n");
        sb.append("Books:\n");
        for (Book bk : books) sb.append("  ").append(bk).append("\n");
        sb.append("Members:\n");
        for (Member mmb : members) sb.append("  ").append(mmb).append("\n");
        sb.append("   ");
        return sb.toString();
    }
    private Book findBook(String isbn) {
        for (Book bk : books)
            if (bk.getIsbn().equals(isbn)) return bk;
        return null;
    }
    private Member findMember(String id) {
        for (Member m : members)
            if (m.getMemberId().equals(id)) return m;
        return null;
    }
}