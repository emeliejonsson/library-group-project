import org.junit.Test;

import se.yrgo.project.Book;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testConstructorAndGetters() {
        Book book = new Book("Sagan om ringen", "Tolkien", "1234567890", 3);

        assertEquals("Sagan om ringen", book.getTitle());
        assertEquals("Tolkien", book.getAuthor());
        assertEquals("1234567890", book.getIsbn());
        assertEquals(3, book.getCopies());
    }

    @Test
    public void testAddCopy() {
        Book book = new Book("Test", "Author", "111", 3);
        book.addCopy(2);
        assertEquals(5, book.getCopies());
    }

    @Test
    public void testAddCopyThrowsExceptionForZeroOrNegative() {
        Book book = new Book("Test", "Author", "111", 3);
        assertThrows(IllegalArgumentException.class, () -> book.addCopy(0));
        assertThrows(IllegalArgumentException.class, () -> book.addCopy(-1));
    }

    @Test
    public void testRemoveCopy() {
        Book book = new Book("Test", "Author", "111", 3);
        boolean result = book.removeCopy(2);
        assertTrue(result);
        assertEquals(1, book.getCopies());
    }

    @Test
    public void testRemoveCopyFailsWhenNotEnoughCopies() {
        Book book = new Book("Test", "Author", "111", 1);
        boolean result = book.removeCopy(5);
        assertFalse(result);
        assertEquals(1, book.getCopies());
    }

    @Test
    public void testIsAvailable() {
        Book book = new Book("Test", "Author", "111", 1);
        assertTrue(book.isAvailable());
        book.removeCopy(1);
        assertFalse(book.isAvailable());
    }
  
public class BookTest
{
	public static void main(String[] args)
	{
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
