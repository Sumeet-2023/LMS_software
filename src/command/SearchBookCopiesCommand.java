package command;

import library.Book;
import library.BookCopy;
import library.Library;
import prompt.Prompter;

import java.util.List;

/**
 * Command to search for book copies based on criteria (ISBN, Title, Author).
 */
public class SearchBookCopiesCommand implements Command {
    private Prompter prompter;
    private Library library;

    /**
     * Constructs a new SearchBookCopiesCommand.
     *
     * @param prompter the prompter to get user input
     * @param library  the library to search within
     */
    public SearchBookCopiesCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter search criteria (ISBN, Title, Author):");
        String criteria = prompter.getInput().toLowerCase();
        List<Book> books = library.getBooks();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(criteria) ||
                    book.getAuthor().toLowerCase().contains(criteria)) {
                for (BookCopy copy : book.getCopies()) {
                    System.out.println("Title: " + book.getTitle() +
                            ", Author: " + book.getAuthor() +
                            ", ISBN: " + book.getISBN() +
                            ", Copy ID: " + copy.getId() +
                            ", Borrowed: " + copy.isBorrowed());
                }
            }
        }
    }
}
