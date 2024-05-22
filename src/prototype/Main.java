package prototype;

import prototype.cli.CLIRunner;
import prototype.library.Library;

import java.util.Scanner;

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
