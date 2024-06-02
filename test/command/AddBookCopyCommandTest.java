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
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(EasyMockExtension.class)
public class AddBookCopyCommandTest {
    private Library library;
    private Prompter prompter;
    private AddBookCopyCommand addBookCopyCommand ;
    @BeforeEach
    void setUp() {
        prompter = EasyMock.createMock(Prompter.class);
        library = EasyMock.createMock(Library.class);
        addBookCopyCommand = new AddBookCopyCommand(prompter, library);
    }
    @Test
    void testExecuteBookCopyAddedSuccessfully() {
        String isbn = "1234567890";
        Book book = createMock(Book.class);

        expect(prompter.getInput()).andReturn(isbn);
        expect(library.findBookByISBN(isbn)).andReturn(book);

        book.addCopy(isA(BookCopy.class));
        expectLastCall().andAnswer(() -> {
            BookCopy actualCopy = (BookCopy) getCurrentArguments()[0];
            assertNotNull(actualCopy.getId());
            assertNotNull(actualCopy.getBook());
            return null;
        }).anyTimes();

        replay(prompter,library);

        addBookCopyCommand.execute();

        verify(prompter,library);
    }
}
