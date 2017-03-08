package cn.fgliu.demo.entity;

import java.io.Serializable;

/**
 * Created by andy on 08/03/2017.
 */

public class Book implements Serializable {
    private String bookName;

    private String author;

    private double price;

    private int pages;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
