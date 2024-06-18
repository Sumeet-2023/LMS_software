package command;

import library.Library;
import prompt.Prompter;

/**
 * Command to delete a customer from the library.
 */
public class DeleteCustomerCommand implements Command {
    private Prompter prompter;
    private Library library;

    /**
     * Constructs a DeleteCustomerCommand.
     *
     * @param prompter the prompter used to get user input
     * @param library  the library from which the customer will be deleted
     */
    public DeleteCustomerCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    /**
     * Executes the command to delete a customer from the library.
     */
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