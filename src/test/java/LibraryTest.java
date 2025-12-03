import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private List<String> booksList;

    @BeforeEach
    public void setup() {
        booksList = new ArrayList<>();
        booksList.add("Test book 1");
        booksList.add("Test book 2");

        library = new Library(booksList);
    }

    @Test
    public void testAddBook() {
        library.addBook("New book");
        assertTrue(booksList.contains("New book"));
        assertEquals(3, booksList.size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("Test book 1", ReasonForRemoval.LOST);
        assertFalse(booksList.contains("Test book 1"));
        assertEquals(ReasonForRemoval.LOST, library.getRemovedBooks().get("Test book 1"));
    }

    @Test
    public void testRemoveBook_NotExist() {
        library.removeBook("This book does not exist", ReasonForRemoval.DAMAGED);
        assertEquals(2, booksList.size());
        assertFalse(library.getRemovedBooks().containsKey("This book does not exist"));
    }
}
