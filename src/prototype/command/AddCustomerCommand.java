package prototype.command;

import prototype.library.Customer;
import prototype.library.Library;
import prototype.prompt.Prompter;

public class AddCustomerCommand implements Command {
    private Prompter prompter;
    private Library library;

    public AddCustomerCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

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
