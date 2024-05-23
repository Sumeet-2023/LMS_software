package command;

import library.Book;
import library.BookCopy;
import library.Library;
import prompt.Prompter;

public class AddBookCopyCommand implements Command {
    private Prompter prompter;
    private Library library;

    public AddBookCopyCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

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
