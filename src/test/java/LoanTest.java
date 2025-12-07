import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LoanTest
{
    private Book book;
    private User user;
    private Loan loan;
    private Loan loan2;
    private LocalDate returnDate;

    public LoanTest()
    {
        book = new Book("hej", "apa", "123123123", 1);
        user = new User("Korv");
        loan = new Loan(1, user, book);
        loan2 = new Loan(1, user, book);
        returnDate = LocalDate.now().plusDays(12);
    }

    @Test
    public void testReturnDate()
    {
        assertEquals(returnDate, loan.getReturnDate(),
                "returnDate should be equal to loans returnDate");
    }

    @Test
    public void testStatus() {
        assertEquals(LoanStatus.ACTIVE, loan.getStatus(), "Should be equal, both ACTIVE");
    }

    @Test
    public void testStolen()
    {
        loan.setRandom(1000);
        assertEquals(LoanStatus.BOOKSTOLEN, loan.getStatus(),
                "Loan Status should be BOOKSTOLEN");
    }

    @Test
    public void testEquals()
    {
        assertEquals(loan, loan2, "loan and loan2 should be equal");
    }

    @Test
    public void testEndLoan() {
        loan.endLoan();
        assertEquals(LoanStatus.OLD, loan.getStatus(), "Status should be equal, both OLD");
    }
}
