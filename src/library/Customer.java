package library;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private List<BookCopy> borrowedCopies;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.borrowedCopies = new ArrayList<>();
    }

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

    public boolean borrowCopy(BookCopy copy) {
       return borrowedCopies.add(copy);
    }

    public boolean returnCopy(int copyID) {
        return borrowedCopies.removeIf(copy -> copy.getId() == copyID);
    }
}
