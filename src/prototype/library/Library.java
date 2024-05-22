package prototype.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Customer> customers;

    public Library() {
        this.books = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
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

    public void addCustomer(Customer customer) {
        customers.add(customer);
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
}
