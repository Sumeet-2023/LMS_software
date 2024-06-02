package command;

import library.BookCopy;
import library.Library;

import java.util.List;

public class ReportNonBorrowedBookCopiesCommand implements Command {
    private Library library;

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
