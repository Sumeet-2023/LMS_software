package command;
import library.Book;
import library.Library;
import org.easymock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import prompt.Prompter;

import static org.easymock.EasyMock.*;
@ExtendWith(EasyMockExtension.class)
public class DeleteBookCopyCommandTest {
    private Library library;
    private Prompter prompter;
    private DeleteBookCopyCommand deleteBookCopyCommand ;
    @BeforeEach
    void setUp() {
        prompter = EasyMock.createMock(Prompter.class);
        library = EasyMock.createMock(Library.class);
        deleteBookCopyCommand = new DeleteBookCopyCommand(prompter, library);
    }
    @Test
    void TestExecute_deleted() {
        String isbn = "1234";
        int copyId = 1;
        Book book = createMock(Book.class);

        expect(prompter.getInput()).andReturn(isbn);
        expect(library.findBookByISBN(isbn)).andReturn(book);
        expect(prompter.getInput()).andReturn(String.valueOf(copyId));
        expect(book.removeCopy(copyId)).andReturn(true);

        replay(prompter,library);
        deleteBookCopyCommand.execute();
        verify(prompter,library);
    }
    @Test
    void TestExecute_copyIdNotFound() {
        String isbn = "1234";
        int copyId = 1;
        Book book = createMock(Book.class);

        expect(prompter.getInput()).andReturn(isbn);
        expect(library.findBookByISBN(isbn)).andReturn(book);
        expect(prompter.getInput()).andReturn(String.valueOf(copyId));
        expect(book.removeCopy(copyId)).andReturn(false);

        replay(prompter, library);

        deleteBookCopyCommand.execute();

        verify(prompter, library);
    }
    @Test
    void TestExecute_bookNull() {
        String isbn = "1234";
        expect(prompter.getInput()).andReturn(isbn);
        expect(library.findBookByISBN(isbn)).andReturn(null);
        replay(prompter,library);
        deleteBookCopyCommand.execute();
        verify(prompter,library);
    }
}