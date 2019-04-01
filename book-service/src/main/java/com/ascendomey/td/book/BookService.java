package com.ascendomey.td.book;

import static com.ascendomey.td.book.BookConfigParams.*;

public class BookService {


    private BookConfig bookConfig;

    public BookService(BookConfig bookConfig){
        this.bookConfig = bookConfig;
    }

    public Book getContent(){
        Book book = new Book(
                bookConfig.get(BOOK_TITLE).toString(),
                bookConfig.get(BOOK_AUTHOR).toString(),
                bookConfig.get(BOOK_price).toString());
        return book;

    }

}
