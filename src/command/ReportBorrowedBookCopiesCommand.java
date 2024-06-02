package command;

import library.BookCopy;
import library.Library;

import java.util.List;

public class ReportBorrowedBookCopiesCommand implements Command {
    private Library library;

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
