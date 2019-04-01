package com.ascendmoney.td.autoconfigure;


import com.ascendomey.td.book.BookConfig;
import com.ascendomey.td.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import static com.ascendomey.td.book.BookConfigParams.*;

@Configuration
@ConditionalOnClass(BookService.class)
@EnableConfigurationProperties(BookProperties.class)
public class BookServiceAutoConfiguration {
    @Autowired
    BookProperties bookProperties;

    @Bean
    @ConditionalOnMissingBean
    public BookConfig bookConfig(){
        System.out.println("Initialized bean book config");
        String title = bookProperties.getTitle() == null? "Default title": bookProperties.getTitle();
        String author = bookProperties.getAuthor()==null? "Default author": bookProperties.getAuthor();
        String price = bookProperties.getPrice()==null? "0.00": bookProperties.getPrice();

        BookConfig bookConfig = new BookConfig();
        bookConfig.setProperty(BOOK_TITLE,title);
        bookConfig.setProperty(BOOK_AUTHOR,author);
        bookConfig.setProperty(BOOK_price,price);
        return bookConfig;
    }

    @ConditionalOnMissingBean
    @Bean
    BookService bookService(BookConfig bookConfig){
        System.out.println("Initialized bean book BookService");
        BookService bookService = new BookService(bookConfig);
        return bookService;
    }

}
