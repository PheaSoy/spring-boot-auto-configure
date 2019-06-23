package org.soyphea.book;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = BookApplication.class)
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
public class BookApplicationTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testReturnBookMatchWithConfiguration(){
        Book book = bookService.getContent();
        assertAll("Should return all matched",
                () -> assertEquals(book.getTitle(),"Cloud Native Java"),
                () -> assertEquals(book.getAuthor(),"Josh Long")
        );
    }
}
