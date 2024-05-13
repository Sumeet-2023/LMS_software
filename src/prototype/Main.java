package prototype;

import prototype.cli.CLIRunner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;

        CLIRunner cliRunner = new CLIRunner();
        while (true) {
            cliRunner.printOptions();
            scanner = new Scanner(System.in);
            cliRunner.getPrompter().setScanner(scanner);
            if (cliRunner.run() == 0)
                break;
        }
    }
}
