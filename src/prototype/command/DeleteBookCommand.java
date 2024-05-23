package command;

import library.Library;
import prompt.Prompter;

public class DeleteBookCommand implements Command {
    private final Prompter prompter;
    private final Library library;

    public DeleteBookCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.print("Enter the ISBN of the book to delete: ");
        String ISBN = prompter.getInput();
        if (library.deleteBookViaISBN(ISBN)) {
            System.out.println("Book Deleted: " + ISBN);
        } else {
            System.out.println("Book not found: " + ISBN);
        }
    }
}
