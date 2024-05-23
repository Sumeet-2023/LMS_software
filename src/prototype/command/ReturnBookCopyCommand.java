package prototype.command;

import prototype.library.BookCopy;
import prototype.library.Customer;
import prototype.library.Library;
import prototype.prompt.Prompter;

public class ReturnBookCopyCommand implements Command {
    private Prompter prompter;
    private Library library;

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
                BookCopy copy = new BookCopy(library.findBookByISBN(customer.getBorrowedCopies().get(0).getBook().getISBN()));
                library.findBookByISBN(copy.getBook().getISBN()).addCopy(copy);
                System.out.println("Book copy returned: " + copyId);
            } else {
                System.out.println("Copy ID not found: " + copyId);
            }
        } else {
            System.out.println("Customer not found: " + id);
        }
    }
}
