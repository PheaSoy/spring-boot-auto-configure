package org.soyphea.book;

import java.time.LocalDate;
import java.util.UUID;

public class BookStoreService {

    private BookService bookService;

    public BookStoreService(BookService bookService){
        this.bookService = bookService;
    }

    public BookStore storeInfo(){
        return new BookStore(UUID.randomUUID().toString(),
                LocalDate.now(),bookService.getContent());
    }
}
