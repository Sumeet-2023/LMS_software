package command;

import library.Book;
import library.Library;
import prompt.Prompter;
import utils.CSVHelper;

import java.io.IOException;
import java.util.List;

public class ImportBooksCommand implements Command{
    private Prompter prompter;
    private Library library;

    public ImportBooksCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Enter the path to the CSV file with books: ");
        String filePath = prompter.getInput();
        try {
            List<String[]> lines = CSVHelper.readCSV(filePath);
            for (String[] line: lines) {
                String ISBN = line[0];
                String title = line[1];
                String author = line[2];
                String genre = line[3];
                String publisher = line[4];
                Book book = new Book(title, author, genre, publisher, ISBN);
                library.addBook(book);
            }
            System.out.println("Books imported successfully.");
        } catch (IOException e) {
            System.out.println("Failed to import books: " + e.getMessage());
        }
    }
}
