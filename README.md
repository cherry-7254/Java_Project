# Library Management System (Java, Console-Based)

## Description
This is an intermediate-level Java project: a console-based Library Management System. It demonstrates object-oriented programming, collections, file I/O, and exception handling.

## Features
- Add, remove, and list books
- Add and list users
- Borrow and return books
- Data persistence using file serialization

## Project Structure
- `src/Book.java` — Book class
- `src/User.java` — User class
- `src/Library.java` — Core logic for managing books, users, and data
- `src/LibraryApp.java` — Main application loop and menu
- `src/Main.java` — Entry point

## How to Compile and Run
1. Open a terminal in the project root directory.
2. Compile all Java files:
   ```sh
   javac -d . src/*.java
   ```
3. Run the application:
   ```sh
   java src.Main
   ```

## Data Persistence
- Book and user data are saved to `books.dat` and `users.dat` in the project root.

## Requirements
- Java 8 or higher

---
This project is ready to use and demonstrates intermediate Java programming skills.