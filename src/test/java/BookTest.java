public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Sagan om ringen", "Ingen aning", "1234567890", 3);

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getIsbn());
        System.out.println(book.getCopies());

        book.addCopy(2);
        System.out.println(book.getCopies());

        boolean removed = book.removeCopy(1);
        System.out.println(removed);
        System.out.println(book.getCopies());

        removed = book.removeCopy(10);
        System.out.println(removed);          
        System.out.println(book.getCopies());

        System.out.println(book.isAvailable());

        book.removeCopy(4);
        System.out.println(book.isAvailable());
    }
}
