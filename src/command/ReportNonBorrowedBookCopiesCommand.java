package command;

import library.BookCopy;
import library.Library;

import java.util.List;

/**
 * Command to report all non-borrowed book copies in the library.
 */
public class ReportNonBorrowedBookCopiesCommand implements Command {
    private Library library;

    /**
     * Constructs a new ReportNonBorrowedBookCopiesCommand.
     *
     * @param library the library from which non-borrowed book copies will be reported
     */
    public ReportNonBorrowedBookCopiesCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        List<BookCopy> nonBorrowedCopies = library.getNonBorrowedBookCopies();
        for (BookCopy copy : nonBorrowedCopies) {
            System.out.println("Title: " + copy.getBook().getTitle() +
                    ", Author: " + copy.getBook().getAuthor() +
                    ", ISBN: " + copy.getBook().getISBN() +
                    ", Copy ID: " + copy.getId());
        }
    }
}
