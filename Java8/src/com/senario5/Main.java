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
    private double price;

    
    public Book(String title, String author, int year, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
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
    
    

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
	}
    
    
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Author 1", 2000,200),
            new Book("Book B", "Author 2", 2005,345),
            new Book("Book C", "Author 1", 2010,254),
            new Book("Book D", "Author 1", 2010,45),
            new Book("Book E", "Author 1", 2010,678),
            new Book("Book F", "Author 4", 2005,1000)
        );

        books.stream().collect(Collectors.groupingBy(Book::getYear,Collectors.summingDouble(Book::getPrice))).forEach((k,v)->{
        	 System.out.println(k+" "+v);
        });
       
        
        
        /*books.stream().collect(Collectors.groupingBy(Book::getAuthor)).forEach((k,v)->{
        	System.out.println(k+" "+v.size());
        	
        	
        });
     */
        
        
      
    }
}
