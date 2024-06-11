package command;

import library.Book;
import library.Library;
import prompt.Prompter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportBookCopiesPerPublisherCommand implements Command {
    private Prompter prompter;
    private Library library;

    public ReportBookCopiesPerPublisherCommand(Prompter prompter, Library library) {
        this.prompter = prompter;
        this.library = library;
    }

    @Override
    public void execute() {
        Map<String, Integer> publisherCopiesCount = new HashMap<>();
        int totalCopies = 0;

        for (Book book : library.getBooks()) {
            String publisher = book.getPublisher();
            int copies = book.getCopies().size();
            totalCopies += copies;
            publisherCopiesCount.put(publisher, publisherCopiesCount.getOrDefault(publisher, 0) + copies);
        }

        final int total = totalCopies; // For lambda use

        List<Map.Entry<String, Integer>> sortedPublishers = publisherCopiesCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        System.out.println("Publisher Report:");
        for (Map.Entry<String, Integer> entry : sortedPublishers) {
            String publisher = entry.getKey();
            int copies = entry.getValue();
            double percentage = (total == 0) ? 0 : (copies * 100.0) / total;
            System.out.printf("%s: %d book copies (%.1f%%)%n", publisher, copies, percentage);
        }
    }
}
