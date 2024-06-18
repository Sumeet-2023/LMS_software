package prompt;
import java.util.Scanner;


/**
 * Prompter class to handle user input prompts.
 */
public class Prompter {
    private Scanner scanner;

    // Constructor
    public Prompter(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Method to display a prompt.
     * @param prompt the prompt string to display.
     */
    public void displayPrompt(String prompt) {
        System.out.print(prompt + " ");
    }

    /**
     * Method to read user input.
     * @return the input string from the user.
     */
    public String getInput() {
        return scanner.nextLine();
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}