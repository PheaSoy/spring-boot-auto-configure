package org.soyphea.book;


import java.time.LocalDate;

public class BookStore   {


    private String storeId;
    private LocalDate storedDate;
    private Book book;

    public BookStore(String storeId, LocalDate storedDate, Book book) {
        this.storeId = storeId;
        this.storedDate = storedDate;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public LocalDate getStoredDate() {
        return storedDate;
    }

    public void setStoredDate(LocalDate storedDate) {
        this.storedDate = storedDate;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "storeId='" + storeId + '\'' +
                ", storedDate=" + storedDate +
                ", book=" + book +
                '}';
    }
}
