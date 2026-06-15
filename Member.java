import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Member {
    private String memberId;
    private String name;
    private List<Loan> loans;

    private static Random rand = new Random();

    // generates a random member ID
    private static String generateMemberId() {
        return "MEM-" + (0 + rand.nextInt(100));
    }

    public Member(String name) {
        this.memberId = generateMemberId();
        this.name = name;
        this.loans = new ArrayList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Loan> getLoans() { return loans; }

    public String addLoan(Loan loan) {
        loans.add(loan);
        return "Loan added for " + name + ". Total active loans: " + loans.size();
    }

    public String removeLoan(Loan loan) {
        loans.remove(loan);
        return "Loan removed for " + name + ". Remaining loans: " + loans.size();
    }

    @Override
    public String toString() {
        return  name + " (ID: " + memberId + ") _ Loans: " + loans.size();
    }
}