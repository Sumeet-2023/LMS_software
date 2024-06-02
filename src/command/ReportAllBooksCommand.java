package command;

import library.Book;
import library.Library;

import java.util.List;

public class ReportAllBooksCommand implements Command {
    private Library library;

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
                    ", ISBN: " + book.getISBN());
        }
    }
}
