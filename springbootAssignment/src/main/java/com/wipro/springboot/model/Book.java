package com.wipro.springboot.model;

public class Book {
    private int bookid;
    private String bookname;
    private String author;
    private int price;

    // ✅ Default constructor (required for Spring & Jackson)
    public Book() {}

    // ✅ All-args constructor (your current usage needs this!)
    public Book(int bookid, String bookname, String author, int price) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    // ✅ Getters and setters
    public int getBookid() { return bookid; }
    public void setBookid(int bookid) { this.bookid = bookid; }

    public String getBookname() { return bookname; }
    public void setBookname(String bookname) { this.bookname = bookname; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}
