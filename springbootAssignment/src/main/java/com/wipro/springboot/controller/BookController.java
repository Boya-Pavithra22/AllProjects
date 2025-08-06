package com.wipro.springboot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.wipro.springboot.model.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private List<Book> books = new ArrayList<>(List.of(
        new Book(1, "Programming with Java", "E. Balagurusamy", 350),
        new Book(2, "Core and Advance Java", "R. Nageswara Rao", 800),
        new Book(3, "Data Structures and Algorithms in Java", "Robert Lafore", 500),
        new Book(4, "Exploring C", "Yashavant Kanetkar", 670)
    ));

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully";
    }

    @PutMapping("/update")
    public String updateBook(@RequestBody Book book) {
        for (Book b : books) {
            if (b.getBookid() == book.getBookid()) {
                b.setBookname(book.getBookname());
                b.setAuthor(book.getAuthor());
                b.setPrice(book.getPrice());
                return "Book updated successfully";
            }
        }
        return "Book not found";
    }

    @DeleteMapping("/delete/{bookid}")
    public String deleteBook(@PathVariable int bookid) {
        books.removeIf(book -> book.getBookid() == bookid);
        return "Book deleted successfully";
    }
}
