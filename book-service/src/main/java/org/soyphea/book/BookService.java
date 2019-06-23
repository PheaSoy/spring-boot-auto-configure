package org.soyphea.book;

public class BookService {


    private BookConfig bookConfig;

    public BookService(BookConfig bookConfig){
        this.bookConfig = bookConfig;
    }

    public Book getContent(){
        Book book = new Book(
                bookConfig.get(BookConfigParams.BOOK_TITLE).toString(),
                bookConfig.get(BookConfigParams.BOOK_AUTHOR).toString(),
                bookConfig.get(BookConfigParams.BOOK_price).toString());
        return book;

    }

}
