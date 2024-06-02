package command;

import library.Customer;
import library.Library;

import java.util.List;

public class ReportAllCustomersCommand implements Command {
    private Library library;

    public ReportAllCustomersCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        List<Customer> customers = library.getCustomers();
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getCustomerId() +
                    ", Name: " + customer.getName() +
                    ", Email: " + customer.getEmail() +
                    ", Books Borrowed: " + customer.getBorrowedCopies().size());
        }
    }
}

