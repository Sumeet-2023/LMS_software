package prototype.cli;

import prototype.command.ExecuteCommand;
import prototype.prompt.Prompter;

import java.util.Scanner;

public class CLIRunner {
    private Prompter prompter;

    // Constructor
    public CLIRunner() {
        this.prompter = new Prompter();
    }

    public void printOptions() {
        System.out.println("Select a process by entering the index number:");
        System.out.println("1. Add a book");
        System.out.println("2. Delete a book");
        System.out.println("3. Add a book copy");
        System.out.println("4. Delete a book copy");
        System.out.println("5. Add a customers");
        System.out.println("6. Delete a customer");
        System.out.println("7. Borrowing a book copy");
        System.out.println("8. Returning a book copy");
        System.out.println("9. Exit");
    }

    // Example usage
    public int run() {
        prompter.displayPrompt("->");
        String input = prompter.getInput();
        if (input.equals("9"))
            return (0);
        if (!input.trim().isEmpty()) {
            ExecuteCommand executeCommand = new ExecuteCommand(Integer.parseInt(input));
        }
        return (1);
    }

    public Prompter getPrompter() {
        return prompter;
    }

    public void setPrompter(Prompter prompter) {
        this.prompter = prompter;
    }


}
