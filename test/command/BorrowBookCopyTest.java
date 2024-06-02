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
public class BorrowBookCopyTest {
    private Library library;
    private Prompter prompter;
    private BorrowBookCopyCommand borrowBookCopyCommand ;
    @BeforeEach
    void setUp() {
        prompter = EasyMock.createMock(Prompter.class);
        library = EasyMock.createMock(Library.class);
        borrowBookCopyCommand = new BorrowBookCopyCommand(prompter, library);
    }
    @Test
    void TestExecute_customerFound_bookFound() {

    }

}
