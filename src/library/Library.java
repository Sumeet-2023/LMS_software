package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Customer> customers;

    public Library() {
        this.books = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        if(book==null) {
            return false;
        }
        for(Book b : books){
            if(b.getISBN().equals(book.getISBN())){
                return false;
            }
        }
        return books.add(book);

    }

    public boolean deleteBookViaISBN(String ISBN) {
        return (books.removeIf(book -> book.getISBN().equals(ISBN)));
    }

    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public boolean addCustomer(Customer customer) {
        if(customer==null){
            return false;
        }
        for(Customer c:customers){
            if(c.getCustomerId().equals(customer.getCustomerId())){
                return false;

            }
        }
        return customers.add(customer);
    }

    public boolean deleteCustomerViaId(String id) {
        return customers.removeIf(customer -> customer.getCustomerId().equals(id));
    }

    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id))
                    return customer;
        }
        return null;
    }

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

    public Customer findCustomerByEmail(String email) {
        return customers.stream()
                .filter(customer -> customer.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public Customer findCustomerById(int id) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId() == String.valueOf(id))
                .findFirst()
                .orElse(null);
    }

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



    public List<Book> getBooks() {
        return books;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
