package com.example.library.controller;

import com.example.library.model.User;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<User> getAllUsers() {
        return libraryService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return libraryService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return libraryService.getUser(id);
    }

    @PostMapping("/{userId}/borrow/{bookId}")
    public boolean borrowBook(@PathVariable String userId, @PathVariable String bookId) {
        return libraryService.borrowBook(userId, bookId);
    }

    @PostMapping("/{userId}/return/{bookId}")
    public boolean returnBook(@PathVariable String userId, @PathVariable String bookId) {
        return libraryService.returnBook(userId, bookId);
    }
}
