package prototype.library;

public class BookCopy {
    private static int idCounter = 1;
    private int id;
    private Book book;

    public BookCopy(Book book) {
        this.id = idCounter++;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }
}
