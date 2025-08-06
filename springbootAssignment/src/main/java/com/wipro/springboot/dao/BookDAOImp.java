package com.wipro.springboot.dao;



import com.wipro.springboot.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookDAOImp implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE bookid = ?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }

    @Override
    public void addBook(Book book) {
        jdbcTemplate.update("INSERT INTO book (bookid, bookname, author, price) VALUES (?, ?, ?, ?)",
                book.getBookid(), book.getBookname(), book.getAuthor(), book.getPrice());
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update("UPDATE book SET bookname = ?, author = ?, price = ? WHERE bookid = ?",
                book.getBookname(), book.getAuthor(), book.getPrice(), book.getBookid());
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE bookid = ?", id);
    }
}
