package library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @Test
    void borrowCopyTest() {
        Book book = new Book("GOT","Sumeet","15","Sumeet","1451");
        BookCopy copy = new BookCopy(book);
        Customer customer = new Customer("#12","modi","modi@gmail.com");

        assertTrue(customer.borrowCopy(copy));
        assertTrue(customer.getBorrowedCopies().contains(copy));
    }
    @Test
    void returnCopyTest(){
        Book book = new Book("GOT","Sumeet","15","Sumeet","1451");
        BookCopy copy = new BookCopy(book);
        Customer customer = new Customer("#12","modi","modi@gmail.com");
        customer.borrowCopy(copy);

        assertTrue(customer.returnCopy(copy.getId()));
        assertFalse(customer.getBorrowedCopies().contains(copy));

    }
}