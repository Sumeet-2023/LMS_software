package library;

/**
 * Represents a copy of a book in the library.
 */
public class BookCopy {
    private static int idCounter = 1;
    private int id;
    private Book book;
    private boolean isBorrowed;
    private Customer borrower;

    /**
     * Constructs a new BookCopy.
     *
     * @param book the book this copy belongs to
     */
    public BookCopy(Book book) {
        this.id = idCounter++;
        this.book = book;
        this.isBorrowed = false;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Customer getBorrower() {
        return borrower;
    }

    public void setBorrower(Customer borrower) {
        this.borrower = borrower;
    }
}
