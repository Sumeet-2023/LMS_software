package library;
import org.junit.jupiter.api.Test;

import prototype.library.Book;
import prototype.library.BookCopy;

import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    @Test
    void addCopyTest() {
        Book book = new Book("GOT","Random","15","Random","1451");
        BookCopy bookCopy = new BookCopy(book);
        int initialSize = book.getCopies().size();

        assertTrue(book.addCopy(bookCopy));
        assertEquals(initialSize+1,book.getCopies().size());
        assertTrue(book.getCopies().contains(bookCopy));
    }
    @Test
    void removeCopyTest() {
        Book book = new Book("GOT","Random","15","Random","1451");
        BookCopy bookCopy1 = new BookCopy(book);
        BookCopy bookCopy2 = new BookCopy(book);

        book.addCopy(bookCopy1);
        book.addCopy(bookCopy2);

        assertTrue(book.removeCopy(bookCopy1.getId()));
        assertFalse(book.getCopies().contains(bookCopy1));
        assertTrue(book.getCopies().contains(bookCopy2));
    }
}