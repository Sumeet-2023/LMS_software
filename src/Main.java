import cli.CLIRunner;
import library.Library;

import java.util.Scanner;

/**
 * Main class to run the Library Management System CLI.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        CLIRunner cliRunner = new CLIRunner(scanner, library);
        while (true) {
            cliRunner.printOptions();
            if (cliRunner.run() == 0)
                break;
        }
        scanner.close();
    }
}
