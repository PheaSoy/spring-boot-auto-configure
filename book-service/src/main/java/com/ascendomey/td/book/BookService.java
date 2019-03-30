package com.ascendomey.td.book;

import static com.ascendomey.td.book.BookConfigParams.*;

public class BookService {


    private BookConfig bookConfig;

    public BookService(BookConfig bookConfig){
        this.bookConfig = bookConfig;
    }

    public String getContent(){
        String message = String.format("This is the book with tile: %s and price %s and author %s",
                bookConfig.get(BOOK_TITLE),bookConfig.get(BOOK_price),bookConfig.get(BOOK_AUTHOR));
        return message;
    }

}
