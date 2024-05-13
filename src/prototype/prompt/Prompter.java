package prototype.prompt;
import java.util.Scanner;

public class Prompter {
    private Scanner scanner;

    // Constructor
    public Prompter() {
    }

    // Method to display a prompt
    public void displayPrompt(String prompt) {
        System.out.print(prompt + " ");
    }

    // Method to read user input
    public String getInput() {
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}