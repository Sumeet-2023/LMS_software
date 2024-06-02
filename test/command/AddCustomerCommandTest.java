package command;
import library.Book;
import library.BookCopy;
import library.Customer;
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
public class AddCustomerCommandTest {
    private Library library;
    private Prompter prompter;
    private AddCustomerCommand addCustomerCommand ;
    @BeforeEach
    void setUp() {
        prompter = EasyMock.createMock(Prompter.class);
        library = EasyMock.createMock(Library.class);
        addCustomerCommand = new AddCustomerCommand(prompter, library);
    }
    @Test
    void testExecute() {
        String name = "John Doe";
        String email = "john.doe@example.com";
        String id = "12345";


        expect(prompter.getInput()).andReturn(name);
        expect(prompter.getInput()).andReturn(email);
        expect(prompter.getInput()).andReturn(id);

        expect(library.addCustomer(anyObject(Customer.class))).andAnswer(() -> {
            Customer customer = (Customer) getCurrentArguments()[0];
            assertEquals(name, customer.getName());
            assertEquals(email, customer.getEmail());
            assertEquals(id, customer.getCustomerId());
            return true;
        });

        replay(prompter, library);

        addCustomerCommand.execute();

        verify(prompter, library);
    }
}
