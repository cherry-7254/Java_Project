package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id) {
        return libraryService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        libraryService.removeBook(id);
    }
}
