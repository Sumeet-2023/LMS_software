package cli;

import command.*;
import library.Library;
import prompt.Prompter;

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
        commandMap.put(1, new ImportBooksCommand(prompter, library));
        commandMap.put(2, new DeleteBookCommand(prompter, library));
        commandMap.put(3, new ImportBookCopiesCommand(prompter, library));
        commandMap.put(4, new DeleteBookCopyCommand(prompter, library));
        commandMap.put(5, new ImportCustomersCommand(prompter, library));
        commandMap.put(6, new DeleteCustomerCommand(prompter, library));
        commandMap.put(7, new SearchBookCopiesCommand(prompter, library));
        commandMap.put(8, new BorrowBookCopyCommand(prompter, library));
        commandMap.put(9, new ReturnBookCopyCommand(prompter, library));
        commandMap.put(10, new ReportAllBooksCommand(library));
        commandMap.put(11, new ReportBorrowedBookCopiesCommand(library));
        commandMap.put(12, new ReportNonBorrowedBookCopiesCommand(library));
        commandMap.put(13, new ReportAllCustomersCommand(library));
        commandMap.put(14, new ReportBorrowedBookCopiesByCustomerCommand(prompter, library));
    }

    public void printOptions() {
        System.out.println("Select a process by entering the index number:");
        System.out.println("1. Import a file with books");
        System.out.println("2. Delete a book");
        System.out.println("3. Import a file with book copies");
        System.out.println("4. Delete a book copy");
        System.out.println("5. Import a file with customers");
        System.out.println("6. Delete a customer");
        System.out.println("7. Search for book copies");
        System.out.println("8. Borrow a book copy");
        System.out.println("9. Return a book copy");
        System.out.println("10. Report: Output of all books");
        System.out.println("11. Report: Output of all borrowed book copies");
        System.out.println("12. Report: Output of all non-borrowed book copies");
        System.out.println("13. Report: Output of all customers");
        System.out.println("14. Report: Output of all currently borrowed book copies of a customer");
        System.out.println("15. Exit");
    }

    public int run() {
        prompter.displayPrompt("->");
        String input = prompter.getInput().trim();
        if (input.equals("15"))
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
