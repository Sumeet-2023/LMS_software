package prototype;

import prototype.cli.CLIRunner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CLIRunner cliRunner = new CLIRunner(scanner);
        while (true) {
            cliRunner.printOptions();
            if (cliRunner.run() == 0)
                break;
        }
    }
}
