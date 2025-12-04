import java.util.*;

public class Library {
    private List<Book> booksList;
    private Map<String, ReasonForRemoval> removedBooks = new HashMap<>();

    public Library() {
        this.booksList = new ArrayList<>();
    }

    public Library(List<Book> booksList) {
        this.booksList = booksList;
    }

    public Book findBook(String bookSearch) {
        for (Book books : this.booksList) {
            if (books.getTitle().equals(bookSearch)) {
                System.out.println(books.getTitle());
                return books;
            }
        }
        System.out.println("Try again");
        return null;

    }

    public void addBook(Book newBook) {
        booksList.add(newBook);
        System.out.println(newBook + " was added to the library catalogue.");
    }

    public void removeBook(String nameOfBook, ReasonForRemoval reason) {
        for (Book book : booksList) {
            if (book.getTitle().equals(nameOfBook)) {
                booksList.remove(book);
                removedBooks.put(nameOfBook, reason);
                System.out.println("Removed: " + nameOfBook + ". Reason for removal: " + reason);
                return;
            }
        }
        System.out.println("Can't find: " + nameOfBook);
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public Map<String, ReasonForRemoval> getRemovedBooks() {
        return removedBooks;
    }

    // find book för att loopa igenom boklistan

    /**ANVÄNDA I MAIN, LÄGGS TILL EFTER booksList
     Library library = new Library(booksList);

     LÄGG TILL ADD/REMOVE I MAIN:
     String bookToAdd = scanner.nextLine();
     library.addBook(bookToAdd);
     break;

     String bookToRemove = scanner.nextLine();
     (print: reason for removal)
     int removalReason = scanner.nextInt();
     scanner.nextLine();

     switch (removalReason) {
     case 1: reason = ReasonForRemoval.LOST;
     break;
     case 2: reason = ReasonForRemoval.DAMAGED;
     break;
     case 3: reason = ReasonForRemoval.SOLD;
     break;
     default: reason = ReasonForRemoval.OTHER;
     break;
     }

     library.removeBook(bookToRemove, reason);
     break;
     */

}
