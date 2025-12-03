import java.util.*;

public class Library {
    private List<Book> booksList;
    private Map<String, ReasonForRemoval> removedBooks = new HashMap<>();


    public Library() {
        this.booksList = new ArrayList<>();
    }

    public void findBook(String bookSearch) {
        for (Book books : this.booksList) {
            if (books.getTitle().equals(bookSearch)) {
                System.out.println(books.getTitle());
                return;
            } else {
                System.out.println("Try again");
            }
        }

    }

    public void addBook(Book newBook) {
        booksList.add(newBook);
        System.out.println(newBook + " was added to the library catalogue.");
    }

    public void removeBook(String nameOfBook, ReasonForRemoval reason) {
        if (booksList.remove(nameOfBook)) {
            removedBooks.put(nameOfBook, reason);
            System.out.println("Removed: " + nameOfBook + ". Reason for removal: " + reason);
        } else {
            System.out.println("Can't find: " + nameOfBook);
        }
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
