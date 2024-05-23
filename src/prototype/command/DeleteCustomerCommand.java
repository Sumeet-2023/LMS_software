package prototype.command;

import prototype.library.Customer;
import prototype.library.Library;
import prototype.prompt.Prompter;
public class DeleteCustomerCommand implements Command {
    private Prompter prompter;
    private Library library;

    public DeleteCustomerCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter the Id of the customer to delete:");
        String id = prompter.getInput();
        if (library.deleteCustomerViaId(id)) {
            System.out.println("Customer deleted: " + id);
        } else {
            System.out.println("Customer not found: " + id);
        }
    }
}
