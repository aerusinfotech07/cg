package com.senario5;

//Scenario 5: Book Library System
//Question: You have a list of books with their titles, authors, and publication years. Write a program to group the books by their authors.
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
	}
    
    
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Author 1", 2000),
            new Book("Book B", "Author 2", 2005),
            new Book("Book C", "Author 1", 2010)
        );

        books.stream().collect(Collectors.groupingBy(Book::getAuthor)).forEach((k,v)->{
        	System.out.println(k+" "+v.size());
        	
        	
        });
     
        
        
      
    }
}
