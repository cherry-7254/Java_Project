package src;

import java.io.*;
import java.util.*;

public class Library implements Serializable {
    private Map<String, Book> books;
    private Map<String, User> users;
    private static final String BOOKS_FILE = "books.dat";
    private static final String USERS_FILE = "users.dat";

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
        loadData();
    }

    public void addBook(Scanner scanner) {
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();
        if (books.containsKey(id)) {
            System.out.println("Book ID already exists.");
            return;
        }
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        books.put(id, new Book(id, title, author));
        System.out.println("Book added.");
    }

    public void removeBook(Scanner scanner) {
        System.out.print("Enter book ID to remove: ");
        String id = scanner.nextLine();
        if (books.remove(id) != null) {
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void addUser(Scanner scanner) {
        System.out.print("Enter user ID: ");
        String id = scanner.nextLine();
        if (users.containsKey(id)) {
            System.out.println("User ID already exists.");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        users.put(id, new User(id, name));
        System.out.println("User added.");
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in library.");
            return;
        }
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public void borrowBook(Scanner scanner) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return;
        }
        book.setBorrowed(true);
        user.borrowBook(bookId);
        System.out.println("Book borrowed.");
    }

    public void returnBook(Scanner scanner) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isBorrowed() || !user.getBorrowedBookIds().contains(bookId)) {
            System.out.println("This book is not borrowed by this user.");
            return;
        }
        book.setBorrowed(false);
        user.returnBook(bookId);
        System.out.println("Book returned.");
    }

    public void saveData() {
        try (ObjectOutputStream outBooks = new ObjectOutputStream(new FileOutputStream(BOOKS_FILE));
             ObjectOutputStream outUsers = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            outBooks.writeObject(books);
            outUsers.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadData() {
        try (ObjectInputStream inBooks = new ObjectInputStream(new FileInputStream(BOOKS_FILE));
             ObjectInputStream inUsers = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            books = (Map<String, Book>) inBooks.readObject();
            users = (Map<String, User>) inUsers.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Ignore, start with empty data
        }
    }
}
