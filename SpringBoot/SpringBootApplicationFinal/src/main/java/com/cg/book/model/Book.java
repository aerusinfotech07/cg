package com.cg.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String title;
    private String author;
    private int year;
    private Genre genre;
    private double rating;

    
    
    public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title, String author, int year, Genre genre, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }
}
