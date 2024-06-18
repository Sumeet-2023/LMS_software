package command;

import library.Book;
import library.BookCopy;
import library.Library;
import prompt.Prompter;

/**
 * Command to add a copy of an existing book in the library.
 */
public class AddBookCopyCommand implements Command {
    private Prompter prompter;
    private Library library;

    /**
     * Constructs an AddBookCopyCommand.
     *
     * @param prompter the prompter used to get user input
     * @param library  the library where the book copy will be added
     */
    public AddBookCopyCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    /**
     * Executes the command to add a new book copy to the library.
     */
    @Override
    public void execute() {
        System.out.println("Enter the ISBN of the book to add a copy:");
        String ISBN = prompter.getInput();
        Book book = library.findBookByISBN(ISBN);
        if (book != null) {
            BookCopy copy = new BookCopy(book);
            book.addCopy(copy);
            System.out.println("Copy added with ID: " + copy.getId());
        } else {
            System.out.println("Book not found: " + ISBN);
        }
    }
}
