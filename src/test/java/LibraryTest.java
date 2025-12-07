import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private List<Book> booksList;

    @BeforeEach
    public void setup() {
        booksList = new ArrayList<>();
        booksList.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 5));
        booksList.add(new Book("1984", "George Orwell", "9780451524935", 3));

        library = new Library(booksList);
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 4);
        library.addBook(newBook);

        assertTrue(booksList.contains(newBook));
        assertEquals(3, booksList.size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("To Kill a Mockingbird", ReasonForRemoval.LOST);
        assertEquals(ReasonForRemoval.LOST, library.getRemovedBooks().get("To Kill a Mockingbird"));
    }

    @Test
    public void testRemoveBook_NotExist() {
        library.removeBook("This book does not exist", ReasonForRemoval.DAMAGED);
        assertEquals(2, booksList.size());
        assertFalse(library.getRemovedBooks().containsKey("This book does not exist"));
    }

    @Test
    public void testFindBook() {
        Book searchBook = library.findBook("To Kill a Mockingbird");
        assertTrue(booksList.contains(searchBook));

    }
}
