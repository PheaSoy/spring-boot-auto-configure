package book;

import com.ascendomey.td.book.Book;
import com.ascendomey.td.book.BookConfig;
import com.ascendomey.td.book.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.ascendomey.td.book.BookConfigParams.*;
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
