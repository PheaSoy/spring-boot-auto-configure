package com.ascendmoney.td.book;

import com.ascendomey.td.book.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

@Component
@Order(1)
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {


    public static HashMap<String,Object> bookStoreCache = new HashMap<>();

    Logger LOGGER = LoggerFactory.getLogger(ApplicationRunner.class);


    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Loading caches..........");
        String id = UUID.randomUUID().toString();
        bookStoreCache.put(id,new BookStore(id,
                LocalDate.now(),
                new Book("java persistence high performance","vladmihalcea","2000")));
    }
}
