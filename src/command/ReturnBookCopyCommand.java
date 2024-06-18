package command;

import library.BookCopy;
import library.Customer;
import library.Library;
import prompt.Prompter;

/**
 * Command to return a borrowed book copy.
 */
public class ReturnBookCopyCommand implements Command {
    private Prompter prompter;
    private Library library;

    /**
     * Constructs a new ReturnBookCopyCommand.
     *
     * @param prompter the prompter to get user input
     * @param library  the library to which the book copy will be returned
     */
    public ReturnBookCopyCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter the ID of the customer:");
        String id = prompter.getInput();
        Customer customer = library.findCustomerById(id);
        if (customer != null) {
            System.out.println("Enter the copy ID to return:");
            int copyId = Integer.parseInt(prompter.getInput());
            if (customer.returnCopy(copyId)) {
                BookCopy copy = library.findBookCopyById(copyId);
                if (copy != null) {
                    copy.setBorrower(null);
                    System.out.println("Book copy returned: " + copyId);
                }
            } else {
                System.out.println("Copy ID not found: " + copyId);
            }
        } else {
            System.out.println("Customer not found: " + id);
        }
    }
}
