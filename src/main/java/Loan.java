import java.time.*;
import java.util.concurrent.ThreadLocalRandom;

public class Loan {
    private final User user;
    private final Book book;
    private final int loanID;
    private final LocalDate returnDate;
    private LoanStatus status;
    private int random;

    public Loan(int loanID, User user, Book book) {
        random = ThreadLocalRandom.current().nextInt(0, 1000);
        this.loanID = loanID;
        this.user = user;
        this.book = book;
        if (random == 1000) {
            status = LoanStatus.BOOKSTOLEN;
        } else {
            status = LoanStatus.ACTIVE;
        }
        returnDate = LocalDate.now().plusDays(12);
    }

    @Override
    public String toString() {
        return String.format("""
                Låne-id: %d
                Bok: %s
                Användare: %s
                Återlämningsdatum: %s
                Lånestatus: %s""", loanID, book.getTitle(), user.getName(), returnDate, status);
    }

    public void endLoan() {
        status = LoanStatus.OLD;
    }

    public void setRandom(int random) {
        this.random = random;
        if (random == 1000) {
            this.status = LoanStatus.BOOKSTOLEN;
        }
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public int getLoanID() {
        return loanID;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + loanID;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Loan other = (Loan) obj;
        if (loanID != other.loanID) return false;
        return true;
    }
}