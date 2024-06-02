package command;

import library.BookCopy;
import library.Customer;
import library.Library;
import prompt.Prompter;

import java.util.List;

public class ReportBorrowedBookCopiesByCustomerCommand implements Command {
    private Prompter prompter;
    private Library library;

    public ReportBorrowedBookCopiesByCustomerCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter the Customer ID of the customer:");
        String ID = prompter.getInput();
        Customer customer = library.findCustomerById(ID);
        if (customer != null) {
            List<BookCopy> borrowedCopies = customer.getBorrowedCopies();
            for (BookCopy copy : borrowedCopies) {
                System.out.println("Title: " + copy.getBook().getTitle() +
                        ", Author: " + copy.getBook().getAuthor() +
                        ", ISBN: " + copy.getBook().getISBN() +
                        ", Copy ID: " + copy.getId());
            }
        } else {
            System.out.println("Customer not found.");
        }
    }
}

