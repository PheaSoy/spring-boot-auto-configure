package org.soyphea.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soyphea.autoconfigure.BookServiceAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = BookServiceAutoConfiguration.class)
@SpringBootApplication
public class BookApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(BookApplication.class);

    }

}
