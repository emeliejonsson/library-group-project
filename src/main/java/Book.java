public class Book {

    private String title;
    private String author;
    private String isbn;

    private int copies;

    public Book(String title, String author, String isbn, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopies() {
        return copies;
    }

    public void addCopy(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        copies += amount;
    }

    public boolean removeCopy(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be positive.");
        }

        if (copies - amount < 0) {
            return false;
        }

        copies -= amount;
        return true;
    }

    public boolean isAvailable() {
        return copies > 0;
    }
}