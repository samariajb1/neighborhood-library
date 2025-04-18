package com.plurasight;

import java.util.Scanner;

public class Register {
    public static void main(String[] args) {

        Book[] books = new Book[20];

        // Fill in books with data
        books[0] = new Book(1, "97812345", "Harry Potter");
        books[1] = new Book(2, "97812346", "Abide");
        books[2] = new Book(3, "97812347", "Refined");
        books[3] = new Book(4, "97812348", "Anchor");
        books[4] = new Book(5, "97812349", "Forgiven");
        books[5] = new Book(6, "97812351", "Rise");
        books[6] = new Book(7, "97812352", "Radiate");
        books[7] = new Book(8, "97812353", "Glory");
        books[8] = new Book(9, "97812354", "Dwell");
        books[9] = new Book(10, "97812355", "Light");
        books[10] = new Book(11, "97812356", "Light 2");
        books[11] = new Book(12, "97812357", "Thorn");
        books[12] = new Book(13, "97812358", "Santify");
        books[13] = new Book(14, "97812359", "Awaken");
        books[14] = new Book(15, "97812361", "Rise");
        books[15] = new Book(16, "97812362", "Quiet");
        books[16] = new Book(17, "97812363", "Glory");
        books[17] = new Book(18, "97812364", "Glory P2");
        books[18] = new Book(19, "97812365", "Rooted");
        books[19] = new Book(20, "97812366", "Harvest");

        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Neighborhood Library!");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            if (choice.equals("1")) {
                showAvailableBooks(books, input);
            } else if (choice.equals("2")) {
                showCheckedOutBooks(books);
            } else if (choice.equals("3")) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void showAvailableBooks(Book[] books, Scanner input) {
        System.out.println("\nAvailable Books:");

        for (int i = 0; i < books.length; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.println("ID: " + books[i].getId() + ", ISBN: " + books[i].getIsbn() + ", Title: " + books[i].getTitle());
            }
        }

        System.out.print("Enter the ID of the book to check out (or type X to go back): ");
        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("X")) {
            return;
        }

        int bookId = Integer.parseInt(userInput);
        boolean found = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i].getId() == bookId && !books[i].isCheckedOut()) {
                System.out.print("Enter your name: ");
                String name = input.nextLine();
                books[i].checkOut(name);
                System.out.println("Checked out to " + name);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found or already checked out.");
        }
    }

    public static void showCheckedOutBooks(Book[] books) {
        System.out.println("\nChecked Out Books:");
        boolean anyCheckedOut = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i].isCheckedOut()) {
                System.out.println("ID: " + books[i].getId()
                        + ", Title: " + books[i].getTitle()
                        + ", Checked out to: " + books[i].getCheckedOutTo());
                anyCheckedOut = true;
            }
        }

        if (!anyCheckedOut) {
            System.out.println("No books are currently checked out.");
        }
    }
}