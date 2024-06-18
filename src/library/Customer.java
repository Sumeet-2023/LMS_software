package library;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer of the library.
 */
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private List<BookCopy> borrowedCopies;

    /**
     * Constructs a new Customer.
     *
     * @param customerId the unique ID of the customer
     * @param name       the name of the customer
     * @param email      the email of the customer
     */
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.borrowedCopies = new ArrayList<>();
    }

    // Getters and setters

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookCopy> getBorrowedCopies() {
        return borrowedCopies;
    }

    /**
     * Borrows a copy of a book.
     *
     * @param copy the copy to borrow
     * @return true if the copy was borrowed successfully, false otherwise
     */
    public boolean borrowCopy(BookCopy copy) {
        copy.setBorrowed(true);
        copy.setBorrower(this);
        return borrowedCopies.add(copy);
    }

    /**
     * Returns a borrowed copy by its ID.
     *
     * @param copyID the ID of the copy to return
     * @return true if the copy was returned successfully, false otherwise
     */
    public boolean returnCopy(int copyID) {
        return borrowedCopies.removeIf(copy -> {
            if (copy.getId() == copyID) {
                copy.setBorrowed(false);
                copy.setBorrower(null);
                return true;
            }
            return false;
        });
    }
}
