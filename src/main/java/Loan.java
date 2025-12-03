import java.time.*;

public class Loan
{
    private User user;
    private Book book;
    private int loanID;
    private LocalDate dueDate;
    private LoanStatus status;

    public Loan(int loanID, User user, Book book)
    {
        this.loanID = loanID;
        this.user = user;
        this.book = book;
        status = LoanStatus.ACTIVE;
        dueDate = LocalDate.now().plusDays(10);
    }

    @Override
    public String toString()
    {
        return String.format("""
                             Loan ID: %d
                             Book: %s
                             User: %s
                             Due date: %s
                             """, loanID, book.getTitle(), user.getName(),
                             dueDate);
    }

    public void endLoan()
    {
        status = LoanStatus.OLD;
    }

    public User getUser()
    {
        return user;
    }

    public Book getBook()
    {
        return book;
    }

    public int getLoanID()
    {
        return loanID;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public LoanStatus getStatus()
    {
        return status;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + loanID;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Loan other = (Loan) obj;
        if (loanID != other.loanID)
            return false;
        return true;
    }
}