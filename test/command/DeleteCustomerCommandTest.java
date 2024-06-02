package command;
import library.Library;
import org.easymock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import prompt.Prompter;

import static org.easymock.EasyMock.*;

@ExtendWith(EasyMockExtension.class)
public class DeleteCustomerCommandTest {
    private Library library;
    private Prompter prompter;
    private DeleteCustomerCommand deleteCustomerCommand ;
    @BeforeEach
    void setUp() {
        prompter = EasyMock.createMock(Prompter.class);
        library = EasyMock.createMock(Library.class);
        deleteCustomerCommand = new DeleteCustomerCommand(prompter, library);
    }
    @Test
    void testExecute_customerFound() {
        String id = "12";
        expect(prompter.getInput()).andReturn(id);
        expect(library.deleteCustomerViaId(id)).andReturn(true);
        replay(prompter,library);
        deleteCustomerCommand.execute();
        verify(prompter,library);
    }
    @Test
    void testExecute_customerNotFound() {
        String id = "10";
        expect(prompter.getInput()).andReturn(id);
        expect(library.deleteCustomerViaId(id)).andReturn(false);
        replay(prompter,library);
        deleteCustomerCommand.execute();
        verify(prompter,library);
    }
}