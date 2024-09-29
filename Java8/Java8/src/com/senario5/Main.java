package com.senario5;

//Scenario 5: Book Library System
//Question: You have a list of books with their titles, authors, and publication years. Write a program to group the books by their authors.

import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private String author;
    private int year;

    // Constructor, getters, and setters
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Author 1", 2000),
            new Book("Book B", "Author 2", 2005),
            new Book("Book C", "Author 1", 2010)
        );

        Map<String, List<Book>> booksByAuthor = books.stream()
            .collect(Collectors.groupingBy(Book::getAuthor));

        booksByAuthor.forEach((author, booksList) -> {
            System.out.println("Author: " + author);
            booksList.forEach(book -> 
                System.out.println("  " + book.getTitle() + " (" + book.getYear() + ")")
            );
        });
    }
}
