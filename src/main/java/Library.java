import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<String> booksList;
    private Map<String, ReasonForRemoval> removedBooks = new HashMap<>();

    public Library(List<String> booksList) {
        this.booksList = booksList;
    }

    public void addBook(String newBook) {
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
    public List<String> getBooksList() {
        return booksList;
    }
    public Map<String, ReasonForRemoval> getRemovedBooks() {
        return removedBooks;
    }

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
