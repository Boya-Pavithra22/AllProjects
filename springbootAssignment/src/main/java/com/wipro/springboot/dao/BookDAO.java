package com.wipro.springboot.dao;

import com.wipro.springboot.model.*;
import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
}
