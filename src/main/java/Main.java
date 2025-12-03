public class Main
{
    public static void main(String[] args)
    {
        User user = new User("apa");

        Book book = new Book("hej", "göran", "129391239", 1);

        Loan loan = new Loan(1, user, book);

        System.out.printf("");
    }

    private static String center(String text, int padding) {
        
    }
}

