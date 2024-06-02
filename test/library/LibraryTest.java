package library;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    void addBookTest() {
        Book book = new Book("GOT","Random","15","Random","1451");
        Library library = new Library();
        int expectedBookSize = library.getBooks().size();
        assertTrue(library.addBook(book));
        assertEquals(expectedBookSize+1,library.getBooks().size());
        assertTrue(library.getBooks().contains(book));
    }
    @Test
    void addNullBookTest(){
        Library library = new Library();

        assertFalse(library.addBook(null));
        assertEquals(0,library.getBooks().size());
    }
    @Test
    void addDuplicateBookTest(){

        Book book1 = new Book("GOT","Sumeet","15","Sumeet","1451");
        Book book2 = new Book("GOT","Sumeet","15","Sumeet","1451"); //same ISBN


        Library library = new Library();
        library.addBook(book1);

        assertFalse(library.addBook(book2));
        assertEquals(1,library.getBooks().size());
        assertTrue(library.getBooks().contains(book1));
    }
    @Test
    void addMultipleBookTest() {
        Book book1 = new Book("Strange","Sumeettt","16","Summet","1234");
        Book book2 = new Book("Strange2","Sumeettt","16","Summet","1423");
        Book book3 = new Book("Strange3","Sumeettt","16","Summet","124");
        Library library = new Library();
        int expectedBookSize = library.getBooks().size();

        assertTrue(library.addBook(book1));
        assertTrue(library.addBook(book2));
        assertTrue(library.addBook(book3));

        assertEquals(expectedBookSize+3,library.getBooks().size());
        assertTrue(library.getBooks().contains(book1));
        assertTrue(library.getBooks().contains(book2));
        assertTrue(library.getBooks().contains(book3));

    }
    @Test
    void deleteBookViaISBNTest() {
        Book book1 = new Book("Strange","Sumeettt","16","Summet","1234");
        Book book2 = new Book("Strange2","Sumeettt","16","Summet","1423");
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        assertEquals(2,library.getBooks().size());

        assertTrue(library.deleteBookViaISBN("1234"));
        assertFalse(library.getBooks().contains(book1));
        assertEquals(1,library.getBooks().size());
        assertNull(library.findBookByISBN("1234"));

        assertFalse(library.deleteBookViaISBN("DoestExist"));
        assertEquals(1,library.getBooks().size());

    }
    @Test
    void findBookViaISBNTest() {
        Book book1 = new Book("Strange","Sumeettt","16","Summet","1234");
        Book book2 = new Book("Strange2","Sumeettt","16","Summet","1423");
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        Book foundBook = library.findBookByISBN("1234");

        assertNotNull(foundBook);
        assertEquals(book1,foundBook);

        Book notFoundBook = library.findBookByISBN("doestExist");

        assertNull(notFoundBook);
    }
    @Test
    void addCustomerTest() {
        Customer customer = new Customer("#12","modi","modi@gmail.com");
        Library library = new Library();

        assertTrue(library.addCustomer(customer));
        assertEquals(1,library.getCustomers().size());
        assertTrue(library.getCustomers().contains(customer));

    }
    @Test
    void addNullCustomerTest() {
        Library library = new Library();

        assertFalse(library.addCustomer(null));
        assertEquals(0,library.getCustomers().size());
    }
    @Test
    void addDuplicateCustomerTest() {
        Customer customer1 = new Customer("#12","modi","modi@gmail.com");
        Customer customer2 = new Customer("#12","modi","modi@gmail.com");
        Library library = new Library();
        library.addCustomer(customer1);

        assertFalse(library.addCustomer(customer2));
        assertEquals(1,library.getCustomers().size());
        assertTrue(library.getCustomers().contains(customer1));
    }
    @Test
    void deleteCustomerViaIdTest() {
        Customer customer1 = new Customer("#12","modi","modi@gmail.com");
        Customer customer2 = new Customer("#13","rahul","rahul@gmail.com");

        Library library = new Library();
        library.addCustomer(customer1);
        library.addCustomer(customer2);

        assertTrue(library.deleteCustomerViaId("#12"));
        assertFalse(library.deleteCustomerViaId("#12"));
        assertTrue(library.deleteCustomerViaId("#13"));
        assertFalse(library.deleteCustomerViaId("#13"));
        assertFalse(library.deleteCustomerViaId("doestExist"));
    }
    @Test
    void findCustomerByIdTest() {
        Customer customer1 = new Customer("#12","modi","modi@gmail.com");
        Customer customer2 = new Customer("#13","rahul","rahul@gmail.com");

        Library library = new Library();
        library.addCustomer(customer1);
        library.addCustomer(customer2);

        assertEquals(customer1,library.findCustomerById("#12"));
        assertEquals(customer2,library.findCustomerById("#13"));
        assertNull(library.findCustomerById("doestExist"));
    }



}
