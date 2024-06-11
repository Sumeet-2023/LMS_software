package command;

import command.Command;
import library.Book;
import library.BookCopy;
import library.Customer;
import library.Library;
import prompt.Prompter;
import utils.CSVHelper;

import java.io.IOException;
import java.util.List;

public class ImportBookCopiesCommand implements Command {
    private Prompter prompter;
    private Library library;

    public ImportBookCopiesCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter the path to the CSV file with book copies:");
        String filePath = prompter.getInput();
        int i = 1;
        try {
            List<String[]> lines = CSVHelper.readCSV(filePath);
            for (String[] line : lines) {
                if (line.length != 1 || line.length != 2) {
                    System.out.println("Invalid Entry at line " + i);
                    continue;
                }
                i++;
                String customerIDStr = "";
                String ISBN = line[0];
                if (line.length == 2) {
                    customerIDStr = line[1];
                }
                Book book = library.findBookByISBN(ISBN);
                if (book != null) {
                    BookCopy copy = new BookCopy(book);
                    book.addCopy(copy);
                    if (!customerIDStr.isEmpty()) {
                        try {
                            String customerID = customerIDStr;
                            Customer customer = library.findCustomerById(customerID);
                            if (customer != null) {
                                copy.setBorrower(customer);
                                customer.borrowCopy(copy);
                            } else {
                                System.out.println("Warning: Customer ID " + customerID + " does not exist. Book copy imported but not borrowed.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Warning: Invalid customer ID format. Book copy imported but not borrowed.");
                        }
                    }
                }
            }
            System.out.println("Book copies imported successfully.");
        } catch (IOException e) {
            System.out.println("Failed to import book copies: " + e.getMessage());
        }
    }
}
