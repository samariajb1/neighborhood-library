package com.plurasight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor: what happens when a Book is created
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false; // starts as not checked out
        this.checkedOutTo = "";    // no one has it yet
    }

    // Method to check out the book
    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    // Method to check in the book
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters (used to get info about the book)
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public String getCheckedOutTo() {
        return checkedOutTo;
    }
}
