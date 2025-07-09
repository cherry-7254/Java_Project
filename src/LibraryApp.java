package src;

import java.util.Scanner;

public class LibraryApp {
    private Library library;
    private Scanner scanner;

    public LibraryApp() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    library.addBook(scanner);
                    break;
                case "2":
                    library.removeBook(scanner);
                    break;
                case "3":
                    library.listBooks();
                    break;
                case "4":
                    library.addUser(scanner);
                    break;
                case "5":
                    library.listUsers();
                    break;
                case "6":
                    library.borrowBook(scanner);
                    break;
                case "7":
                    library.returnBook(scanner);
                    break;
                case "0":
                    running = false;
                    library.saveData();
                    System.out.println("Exiting. Data saved.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Library Management System ---");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. List Books");
        System.out.println("4. Add User");
        System.out.println("5. List Users");
        System.out.println("6. Borrow Book");
        System.out.println("7. Return Book");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }
}
