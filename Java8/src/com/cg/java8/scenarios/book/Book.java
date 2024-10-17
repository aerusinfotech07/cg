package com.cg.java8.scenarios.book;

public class Book {
    private String title;
    private String author;
    private int year;
    private Genre genre;
    private double rating;

    public Book(String title, String author, int year, Genre genre, double rating) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
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
