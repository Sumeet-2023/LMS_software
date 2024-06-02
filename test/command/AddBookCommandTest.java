package command;
import library.Book;
import library.BookCopy;
import library.Library;
import org.easymock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import prompt.Prompter;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(EasyMockExtension.class)
public class AddBookCommandTest {
    private Library library;
    private Prompter prompter;
    private AddBookCommand addBookCommand ;
    @BeforeEach
    void setUp() {
        prompter = EasyMock.createMock(Prompter.class);
        library = EasyMock.createMock(Library.class);
        addBookCommand = new AddBookCommand(prompter, library);
    }
    @Test
    void TestExecute() {
        String title = "Title";
        String author = "Author";
        String genre = "Genre";
        String publisher = "Publisher";
        String isbn = "ISBN";

        expect(prompter.getInput()).andReturn(title);
        expect(prompter.getInput()).andReturn(author);
        expect(prompter.getInput()).andReturn(genre);
        expect(prompter.getInput()).andReturn(publisher);
        expect(prompter.getInput()).andReturn(isbn);

        Book expectedBook = new Book(title, author, genre, publisher, isbn);

        expect(library.addBook(anyObject(Book.class))).andAnswer(() -> {
            Book actualBook = (Book) getCurrentArguments()[0];
            assertEquals(expectedBook.getTitle(), actualBook.getTitle());
            assertEquals(expectedBook.getAuthor(), actualBook.getAuthor());
            assertEquals(expectedBook.getGenre(), actualBook.getGenre());
            assertEquals(expectedBook.getPublisher(), actualBook.getPublisher());
            assertEquals(expectedBook.getISBN(), actualBook.getISBN());
            return false;
        });

        replay(prompter, library);

        addBookCommand.execute();

        verify(prompter, library);
    }

}
