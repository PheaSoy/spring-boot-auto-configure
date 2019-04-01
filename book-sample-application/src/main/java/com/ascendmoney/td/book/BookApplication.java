package com.ascendmoney.td.book;

import com.ascendmoney.td.autoconfigure.BookServiceAutoConfiguration;
import com.ascendmoney.td.server.config.EnablePipelineReady;
import com.ascendomey.td.book.Book;
import com.ascendomey.td.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration
////@EnableAutoConfiguration
////@Import(BookServiceAutoConfiguration.class)

@SpringBootApplication
@EnableBookStore
@EnablePipelineReady
public class BookApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookApplication.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookStoreService bookStoreService;

    public static void main(String args[]) {
        SpringApplication.run(BookApplication.class);

    }

    @Override
    public void run(String... strings) throws Exception {
        Book content = bookService.getContent();
        LOGGER.info("Book Content: {}", content);
        BookStore bookStore = bookStoreService.storeInfo();
        LOGGER.info("BookStore:{}", bookStore);
    }

}
