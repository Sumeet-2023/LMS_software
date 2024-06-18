package command;

import library.Book;
import library.Library;

import java.util.List;

/**
 * Command to report all books in the library.
 */
public class ReportAllBooksCommand implements Command {
    private Library library;

    /**
     * Constructs a new ReportAllBooksCommand.
     *
     * @param library the library from which books will be reported
     */
    public ReportAllBooksCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        List<Book> books = library.getBooks();
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre() +
                    ", Publisher: " + book.getPublisher() +
                    ", ISBN: " + book.getISBN());
        }
    }
}
