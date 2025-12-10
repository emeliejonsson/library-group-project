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
            if (books.getTitle().equalsIgnoreCase(bookSearch)) {
                System.out.println(books.getTitle());
                return books;
            }
        }
        System.out.println();
        System.out.println("Ingen matching för " + bookSearch + " hittades. Kontrollera stavningen eller försök med en annan titel.");
        return null;

    }

    public void addBook(Book newBook) {
        booksList.add(newBook);
        System.out.println(newBook.getTitle() + " av " + newBook.getAuthor() + " har lagts till i katalogen.");
    }

    public void removeBook(String nameOfBook, ReasonForRemoval reason) {
        for (Book book : booksList) {
            if (book.getTitle().equalsIgnoreCase(nameOfBook)) {
                booksList.remove(book);
                removedBooks.put(nameOfBook, reason);
                System.out.println(nameOfBook + " har gallrats från katalogen. Anledning för gallring: " + reason);
                return;
            }
        }
        System.out.println("Ingen matchning för " + nameOfBook + " hittades. Kontrollera stavningen eller försök med en anan titel.");
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public Map<String, ReasonForRemoval> getRemovedBooks() {
            return removedBooks;
    }
    public void listRemovedBooks() {
        for (Map.Entry<String, ReasonForRemoval> entry : getRemovedBooks().entrySet()) {
            System.out.println(entry.getKey() + " har tagits bort. Anledning till borttagning: " + entry.getValue());
        }
    }
}
