package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryService {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public Book addBook(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public boolean removeBook(String id) {
        return books.remove(id) != null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User addUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public boolean borrowBook(String userId, String bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);
        if (user == null || book == null || book.isBorrowed()) {
            return false;
        }
        book.setBorrowed(true);
        user.getBorrowedBookIds().add(bookId);
        return true;
    }

    public boolean returnBook(String userId, String bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);
        if (user == null || book == null || !book.isBorrowed() || !user.getBorrowedBookIds().contains(bookId)) {
            return false;
        }
        book.setBorrowed(false);
        user.getBorrowedBookIds().remove(bookId);
        return true;
    }
}
