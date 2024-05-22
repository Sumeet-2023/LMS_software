package prototype.cli;

import prototype.command.AddBookCommand;
import prototype.command.Command;
import prototype.library.Library;
import prototype.prompt.Prompter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CLIRunner {
    private final Prompter prompter;
    private Map<Integer, Command> commandMap;
    private Library library;

    // Constructor
    public CLIRunner(Scanner scanner, Library library) {
        this.prompter = new Prompter(scanner);
        this.library = library;
        initializeCommands();
    }

    private void initializeCommands() {
        commandMap = new HashMap<>();
        commandMap.put(1, new AddBookCommand(prompter, library));
//        commandMap.put(2, new DeleteBookCommand(prompter));
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

    public int run() {
        prompter.displayPrompt("->");
        String input = prompter.getInput().trim();
        if (input.equals("9"))
            return (0);
        try {
            int commandNumber = Integer.parseInt(input);
            Command command = commandMap.get(commandNumber);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Invalid command number: " + commandNumber);
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter a valid number.");
        }
        return (1);
    }

}
