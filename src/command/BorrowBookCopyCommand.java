package command;

import library.Book;
import library.BookCopy;
import library.Customer;
import library.Library;
import prompt.Prompter;

/**
 * Command to borrow a book copy from the library.
 */
public class BorrowBookCopyCommand implements Command {
    private Prompter prompter;
    private Library library;

    /**
     * Constructs a BorrowBookCopyCommand.
     *
     * @param prompter the prompter used to get user input
     * @param library  the library from which the book copy will be borrowed
     */
    public BorrowBookCopyCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    /**
     * Executes the command to borrow a book copy from the library.
     */
    @Override
    public void execute() {
        System.out.println("Enter the Id of the customer:");
        String id = prompter.getInput();
        Customer customer = library.findCustomerById(id);
        if (customer != null) {
            System.out.println("Enter the ISBN of the book to borrow:");
            String ISBN = prompter.getInput();
            Book book = library.findBookByISBN(ISBN);
            if (book != null && !book.getCopies().isEmpty()) {
                BookCopy copy = book.getCopies().remove(0);
                copy.setBorrowed(true);
                customer.borrowCopy(copy);
                System.out.println("Book copy borrowed: " + copy.getId());
            } else {
                System.out.println("No copies available for book: " + ISBN);
            }
        } else {
            System.out.println("Customer not found: " + id);
        }
    }
}
