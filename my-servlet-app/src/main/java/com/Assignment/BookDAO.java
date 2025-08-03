package com.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	private static final String jdbcURL = "jdbc:mysql://localhost:3306/wipro";
    private static final String jdbcUser = "root";
    private static final String jdbcPass = "S@isrujan123";

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
    }
    
    public static void insertBook(Book book) {
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setFloat(3, book.getPrice());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static List<Book> listAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"));
                list.add(b);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    
    public static Book getBook(int id) {
        String sql = "SELECT * FROM books WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Book(id, rs.getString("title"), rs.getString("author"), rs.getFloat("price"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
    
    public static void updateBook(Book book) {
        String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setFloat(3, book.getPrice());
            ps.setInt(4, book.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    public static void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}


