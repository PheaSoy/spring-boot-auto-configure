package com.ascendmoney.td.book;

import com.ascendomey.td.book.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = BookApplication.class)
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
public class BookApplicationTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testReturnBookMatchWithConfiguration(){
        String content = bookService.getContent();
        assertAll("Should return all matched",
                () -> assertTrue(content.contains("Spring In Action")),
                () -> assertTrue(content.contains("100$"))
        );
    }
}
