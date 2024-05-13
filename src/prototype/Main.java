package prototype;

import prototype.cli.CLIRunner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;

        System.out.println("Welcome to the Command Line Interface!");
        CLIRunner cliRunner = new CLIRunner();
        while (true) {
            scanner = new Scanner(System.in);
            cliRunner.getPrompter().setScanner(scanner);
            cliRunner.run();
        }
    }
}
