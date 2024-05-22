package prototype.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean deleteBookViaISBN(String ISBN) {
        return (books.removeIf(book -> book.getISBN().equals(ISBN)));
    }

}
