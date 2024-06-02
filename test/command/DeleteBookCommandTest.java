package command;

import library.Library;
import org.easymock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import prompt.Prompter;

import static org.easymock.EasyMock.*;

@ExtendWith(EasyMockExtension.class)
public class DeleteBookCommandTest {
    private Library library;
    private Prompter prompter;
    private DeleteBookCommand deleteBookCommand ;
    @BeforeEach
    void setUp() {
        prompter = EasyMock.createMock(Prompter.class);
        library = EasyMock.createMock(Library.class);
        deleteBookCommand = new DeleteBookCommand(prompter, library);
    }
    @Test
    void testExecuteDelete() {
        String isbnToDelete = "12345";
        expect(prompter.getInput()).andReturn(isbnToDelete);
        expect(library.deleteBookViaISBN(isbnToDelete)).andReturn(true);
        replay(prompter,library);

        deleteBookCommand.execute();

        verify(prompter,library);

    }
    @Test
    void testExecuteNotFound() {
        String isbnToDelete = "6789";
        expect(prompter.getInput()).andReturn(isbnToDelete);
        expect(library.deleteBookViaISBN(isbnToDelete)).andReturn(false);
        replay(prompter,library);

        deleteBookCommand.execute();

        verify(prompter,library);
    }
}
