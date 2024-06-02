package command;
import library.Book;
import library.Customer;
import library.Library;
import org.easymock.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EasyMockExtension.class)
public class ReportAllCustomerTest {
    private Library library;
    private ReportAllCustomersCommand reportAllCustomersCommand;
    @BeforeEach
    void setUp() {
        library = EasyMock.createMock(Library.class);
        reportAllCustomersCommand = new ReportAllCustomersCommand( library);
    }
    @Test
    void testExecute() {
        Customer customer1 = new Customer("1", "Raju", "raju.doe@example.com");
        List<Customer> customers = List.of(customer1);

        // Set expectations for the library mock
        expect(library.getCustomers()).andReturn(customers);

        // Set the mocks to replay mode
        replay(library);

        // Capture the system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Execute the command
        reportAllCustomersCommand.execute();

        // Verify the output
        String expectedOutput = "ID: 1, Name: Raju, Email: raju.doe@example.com, Books Borrowed: 0";
        String actualOutput = outContent.toString().trim();
        assertEquals(expectedOutput, actualOutput);

        // Reset the system output
        System.setOut(System.out);

        // Verify that all expectations were met
        verify(library);
    }
}
