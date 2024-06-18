package command;

import library.Customer;
import library.Library;
import prompt.Prompter;

/**
 * Command to add a new customer to the library.
 */
public class AddCustomerCommand implements Command {
    private Prompter prompter;
    private Library library;

    /**
     * Constructs an AddCustomerCommand.
     *
     * @param prompter the prompter used to get user input
     * @param library  the library where the customer will be added
     */
    public AddCustomerCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    /**
     * Executes the command to add a new customer to the library.
     */
    @Override
    public void execute() {
        System.out.println("Enter the name of the customer:");
        String name = prompter.getInput();
        System.out.println("Enter the email of the customer:");
        String email = prompter.getInput();
        System.out.println("Enter the ID of the customer:");
        String id = prompter.getInput();
        Customer customer = new Customer(id, name, email);
        library.addCustomer(customer);
        System.out.println("Customer added: " + name);
    }
}