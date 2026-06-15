import java.time.LocalDate;
public class Loan {
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    
    public Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14);
        this.book.setAvailable(false);
    }

    // Getter methods
    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // Setter methods
    public void setMember(Member member) {
        this.member = member;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Returns a string representation of the loan.
     */
    @Override
    public String toString() {
        return "Loan (" + member.getName() + "|" + book.getTitle()  + ":  Date Borrowed-" + borrowDate + ":  Due Date-" + dueDate + ")";
    }
}