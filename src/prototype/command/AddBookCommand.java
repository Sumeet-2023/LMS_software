package prototype.command;

import prototype.library.Book;
import prototype.library.Library;
import prototype.prompt.Prompter;

public class AddBookCommand implements Command {
    private Prompter prompter;
    private Library library;

    public AddBookCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.print("Enter the title of the book: ");
        String title = prompter.getInput();
        System.out.print("Enter the author of the book: ");
        String author = prompter.getInput();
        System.out.print("Enter the genre of the book: ");
        String genre = prompter.getInput();
        System.out.print("Enter the publisher of the book: ");
        String publisher = prompter.getInput();
        System.out.print("Enter the ISBN of the book: ");
        String ISBN = prompter.getInput();
        library.addBook(new Book(title, author, genre, publisher, ISBN));
        System.out.println("Book added: " + title + " by " + author);
    }
}
