package book;

import org.soyphea.book.Book;
import org.soyphea.book.BookConfig;
import org.soyphea.book.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.soyphea.book.BookConfigParams.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    BookService bookService;

    BookConfig bookConfig = new BookConfig();

    @BeforeEach
    public void setUp(){
        bookConfig.put(BOOK_TITLE,"Cloud Native Java");
        bookConfig.put(BOOK_price,900);
        bookConfig.put(BOOK_AUTHOR,"Josh Long");
        bookService = new BookService(bookConfig);
    }

    @Test
    @DisplayName("Test return book content should ok.")
    public void testOK(){
        Book book = bookService.getContent();
        assertAll("Should return all matched",
                () -> assertEquals(book.getTitle(),"Cloud Native Java"),
                () -> assertEquals(book.getAuthor(),"Josh Long")
        );
    }
}
