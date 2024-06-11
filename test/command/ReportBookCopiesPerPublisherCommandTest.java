package command;

import library.Book;
import library.BookCopy;
import library.Library;
import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import prompt.Prompter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EasyMockExtension.class)
public class ReportBookCopiesPerPublisherCommandTest {
    private Library library;
    private ReportBookCopiesPerPublisherCommand reportBookCopiesPerPublisherCommand;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        library = EasyMock.createMock(Library.class);
        Prompter prompter = EasyMock.createMock(Prompter.class);
        reportBookCopiesPerPublisherCommand = new ReportBookCopiesPerPublisherCommand(prompter, library);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testExecute() {
        // Create sample books and book copies
        Book book1 = new Book("Effective Java", "Joshua Bloch", "Programming", "Addison-Wesley", "978-0134685991");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "Programming", "Prentice Hall", "978-0132350884");
        Book book3 = new Book("Head First Design Patterns", "Eric Freeman", "Software Engineering", "O'Reilly Media", "978-0596007126");

        BookCopy copy1 = new BookCopy(book1);
        BookCopy copy2 = new BookCopy(book1);
        BookCopy copy3 = new BookCopy(book2);
        BookCopy copy4 = new BookCopy(book3);
        BookCopy copy5 = new BookCopy(book3);

        book1.addCopy(copy1);
        book1.addCopy(copy2);
        book2.addCopy(copy3);
        book3.addCopy(copy4);
        book3.addCopy(copy5);

        // Each book already has one copy created when instantiated, so add one more copy for each
        List<Book> books = List.of(book1, book2, book3);

        expect(library.getBooks()).andReturn(books);

        replay(library);

        reportBookCopiesPerPublisherCommand.execute();

        String expectedOutput = "Publisher Report:" + System.lineSeparator() +
                "Addison-Wesley: 3 book copies (37.5%)" + System.lineSeparator() +
                "O'Reilly Media: 3 book copies (37.5%)" + System.lineSeparator() +
                "Prentice Hall: 2 book copies (25.0%)";

        String actualOutput = outContent.toString().trim();
        assertEquals(expectedOutput, actualOutput);

        verify(library);
    }
}
