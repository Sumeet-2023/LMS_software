package command;

import command.Command;
import library.Book;
import library.BookCopy;
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
        try {
            List<String[]> lines = CSVHelper.readCSV(filePath);
            for (String[] line : lines) {
                String ISBN = line[0];
                Book book = library.findBookByISBN(ISBN);
                if (book != null) {
                    BookCopy copy = new BookCopy(book);
                    book.addCopy(copy);
                }
            }
            System.out.println("Book copies imported successfully.");
        } catch (IOException e) {
            System.out.println("Failed to import book copies: " + e.getMessage());
        }
    }
}
