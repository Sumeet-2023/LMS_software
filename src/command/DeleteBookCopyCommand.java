package command;

import library.Book;
import library.Library;
import prompt.Prompter;

/**
 * Command to delete a copy of a book from the library.
 */
public class DeleteBookCopyCommand implements Command {
    private final Prompter prompter;
    private final Library library;

    /**
     * Constructs a DeleteBookCopyCommand.
     *
     * @param prompter the prompter used to get user input
     * @param library  the library from which the book copy will be deleted
     */
    public DeleteBookCopyCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    /**
     * Executes the command to delete a copy of a book from the library.
     */
    @Override
    public void execute() {
        System.out.println("Enter the ISBN of the book to delete a copy:");
        String ISBN = prompter.getInput();
        Book book = library.findBookByISBN(ISBN);
        if (book != null) {
            System.out.println("Enter the copy ID to delete:");
            int copyId = Integer.parseInt(prompter.getInput());
            if (book.removeCopy(copyId)) {
                System.out.println("Copy deleted: ID " + copyId);
            } else {
                System.out.println("Copy ID not found: " + copyId);
            }
        } else {
            System.out.println("Book not found: " + ISBN);
        }
    }
}