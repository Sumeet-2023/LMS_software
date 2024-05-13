package prototype.cli;

import prototype.prompt.Prompter;

import java.util.Scanner;

public class CLIRunner {
    private Prompter prompter;

    // Constructor
    public CLIRunner() {
        this.prompter = new Prompter();
    }

    // Example usage
    public void run() {
        prompter.displayPrompt("->");
        String input = prompter.getInput();
        if (!input.trim().isEmpty()) {
            System.out.println(input);
        }

    }

    public Prompter getPrompter() {
        return prompter;
    }

    public void setPrompter(Prompter prompter) {
        this.prompter = prompter;
    }


}
