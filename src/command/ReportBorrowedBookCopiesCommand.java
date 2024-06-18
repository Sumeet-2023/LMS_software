package command;

import library.BookCopy;
import library.Library;

import java.util.List;

/**
 * Command to report all borrowed book copies in the library.
 */
public class ReportBorrowedBookCopiesCommand implements Command {
    private Library library;

    /**
     * Constructs a new ReportBorrowedBookCopiesCommand.
     *
     * @param library the library from which borrowed book copies will be reported
     */
    public ReportBorrowedBookCopiesCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        List<BookCopy> borrowedCopies = library.getBorrowedBookCopies();
        for (BookCopy copy : borrowedCopies) {
            System.out.println("Title: " + copy.getBook().getTitle() +
                    ", Author: " + copy.getBook().getAuthor() +
                    ", ISBN: " + copy.getBook().getISBN() +
                    ", Copy ID: " + copy.getId() +
                    ", Borrowed by: " + copy.getBorrower().getName());
        }
    }
}
