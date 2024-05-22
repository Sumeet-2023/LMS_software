package prototype.command;

import prototype.prompt.Prompter;

public class AddBookCommand implements Command {
    private Prompter prompter;

    public AddBookCommand(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public void execute() {
        System.out.println("Enter the title of the book:");
        String title = prompter.getInput();
        System.out.println("Enter the author of the book:");
        String author = prompter.getInput();
        System.out.println("Enter the genre of the book:");
        String genre = prompter.getInput();
        System.out.println("Enter the publisher of the book:");
        String publisher = prompter.getInput();
        System.out.println("Book added: " + title + " by " + author);
    }
}
