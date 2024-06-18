package command;

import library.Library;
import prompt.Prompter;

/**
 * Command to delete a book from the library.
 */
public class DeleteBookCommand implements Command {
    private final Prompter prompter;
    private final Library library;

    /**
     * Constructs a DeleteBookCommand.
     *
     * @param prompter the prompter used to get user input
     * @param library  the library from which the book will be deleted
     */
    public DeleteBookCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    /**
     * Executes the command to delete a book from the library.
     */
    @Override
    public void execute() {
        System.out.print("Enter the ISBN of the book to delete: ");
        String ISBN = prompter.getInput();
        if (library.deleteBookViaISBN(ISBN)) {
            System.out.println("Book Deleted: " + ISBN);
        } else {
            System.out.println("Book not found: " + ISBN);
        }
    }
}