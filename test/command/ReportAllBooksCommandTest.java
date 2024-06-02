package command;
import library.Book;
import library.Library;
import org.easymock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EasyMockExtension.class)
public class ReportAllBooksCommandTest {
    private Library library;
    private ReportAllBooksCommand reportAllBooksCommand;
    @BeforeEach
    void setUp() {
        library = EasyMock.createMock(Library.class);
        reportAllBooksCommand = new ReportAllBooksCommand( library);
    }
    @Test
    void testExecute() {
        Book book1 = new Book("Title1", "Author1", "Genre1", "Publisher1", "ISBN1");
        List<Book> books = List.of(book1);

        expect(library.getBooks()).andReturn(books);

        replay(library);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        reportAllBooksCommand.execute();

        String expectedOutput = "Title: Title1, Author: Author1, Genre: Genre1, Publisher: Publisher1, ISBN: ISBN1";
        String actualOutput = outContent.toString().trim();
        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out);

        verify(library);
    }
}
