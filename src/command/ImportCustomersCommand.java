package command;

import library.Customer;
import library.Library;
import prompt.Prompter;
import utils.CSVHelper;

import java.io.IOException;
import java.util.List;

public class ImportCustomersCommand implements Command {
    private Prompter prompter;
    private Library library;

    public ImportCustomersCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter the path to the CSV file with customers:");
        String filePath = prompter.getInput();
        try {
            List<String[]> lines = CSVHelper.readCSV(filePath);
            for (String[] line : lines) {
                String ID = line[0];
                String name = line[1];
                String email = line[2];
                Customer customer = new Customer(ID, name, email);
                library.addCustomer(customer);
            }
            System.out.println("Customers imported successfully.");
        } catch (IOException e) {
            System.out.println("Failed to import customers: " + e.getMessage());
        }
    }
}
