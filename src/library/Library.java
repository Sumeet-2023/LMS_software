package library;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library that manages books, customers, and book copies.
 */
public class Library {
    private List<Book> books;
    private List<Customer> customers;

    /**
     * Constructs a new Library.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    /**
     * Adds a book to the library.
     *
     * @param book the book to add
     * @return true if the book was added successfully, false otherwise
     */
    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                return false;
            }
        }
        return books.add(book);
    }

    /**
     * Deletes a book from the library via its ISBN.
     *
     * @param ISBN the ISBN of the book to delete
     * @return true if the book was deleted successfully, false otherwise
     */
    public boolean deleteBookViaISBN(String ISBN) {
        return books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    /**
     * Finds a book by its ISBN.
     *
     * @param ISBN the ISBN of the book
     * @return the book if found, null otherwise
     */
    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Adds a customer to the library.
     *
     * @param customer the customer to add
     * @return true if the customer was added successfully, false otherwise
     */
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customer.getCustomerId())) {
                return false;
            }
        }
        return customers.add(customer);
    }

    /**
     * Deletes a customer from the library via their ID.
     *
     * @param id the ID of the customer to delete
     * @return true if the customer was deleted successfully, false otherwise
     */
    public boolean deleteCustomerViaId(String id) {
        return customers.removeIf(customer -> customer.getCustomerId().equals(id));
    }

    /**
     * Finds a customer by their ID.
     *
     * @param id the ID of the customer
     * @return the customer if found, null otherwise
     */
    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Gets a list of borrowed book copies.
     *
     * @return the list of borrowed book copies
     */
    public List<BookCopy> getBorrowedBookCopies() {
        List<BookCopy> borrowedCopies = new ArrayList<>();
        for (Book book : books) {
            for (BookCopy copy : book.getCopies()) {
                if (copy.isBorrowed()) {
                    borrowedCopies.add(copy);
                }
            }
        }
        return borrowedCopies;
    }

    /**
     * Gets a list of non-borrowed book copies.
     *
     * @return the list of non-borrowed book copies
     */
    public List<BookCopy> getNonBorrowedBookCopies() {
        List<BookCopy> nonBorrowedCopies = new ArrayList<>();
        for (Book book : books) {
            for (BookCopy copy : book.getCopies()) {
                if (!copy.isBorrowed()) {
                    nonBorrowedCopies.add(copy);
                }
            }
        }
        return nonBorrowedCopies;
    }

    /**
     * Finds a customer by their email.
     *
     * @param email the email of the customer
     * @return the customer if found, null otherwise
     */
    public Customer findCustomerByEmail(String email) {
        return customers.stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds a book copy by its ID.
     *
     * @param id the ID of the book copy
     * @return the book copy if found, null otherwise
     */
    public BookCopy findBookCopyById(int id) {
        for (Book book : books) {
            for (BookCopy copy : book.getCopies()) {
                if (copy.getId() == id) {
                    return copy;
                }
            }
        }
        return null;
    }

    // Getters

    public List<Book> getBooks() {
        return books;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
