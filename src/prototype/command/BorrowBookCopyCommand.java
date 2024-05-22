package prototype.command;

import prototype.library.Book;
import prototype.library.BookCopy;
import prototype.library.Customer;
import prototype.library.Library;
import prototype.prompt.Prompter;

public class BorrowBookCopyCommand implements Command {
    private Prompter prompter;
    private Library library;

    public BorrowBookCopyCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

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