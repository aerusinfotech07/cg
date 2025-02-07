package com.cg.book.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.cg.book.model.Book;
import com.cg.book.model.Genre;

@Repository
public class BookDAOImpl implements BookDAO{	

	@Override
	public List<Book> findAll() {
		return Arrays.asList(
                new Book(1,"The Great Gatsby", "F. Scott Fitzgerald", 1925, Genre.FICTION, 8.5),
                new Book(2,"1984", "George Orwell", 1949, Genre.FICTION, 9.0),
                new Book(3,"To Kill a Mockingbird", "Harper Lee", 1960, Genre.FICTION, 9.2),
                new Book(4,"A Brief History of Time", "Stephen Hawking", 1988, Genre.NON_FICTION, 8.6),
                new Book(5,"The Catcher in the Rye", "J.D. Salinger", 1951, Genre.FICTION, 7.5),
                new Book(6,"The Hobbit", "J.R.R. Tolkien", 1937, Genre.FANTASY, 9.1),
                new Book(7,"The Da Vinci Code", "Dan Brown", 2003, Genre.MYSTERY, 6.4),
                new Book(8,"Sapiens", "Yuval Noah Harari", 2011, Genre.NON_FICTION, 9.0),
                new Book(9,"The Silent Patient", "Alex Michaelides", 2019, Genre.MYSTERY, 8.0),
                new Book(10,"Dune", "Frank Herbert", 1965, Genre.SCIFI, 8.8),
                new Book(11,"Becoming", "Michelle Obama", 2018, Genre.BIOGRAPHY, 9.5),
                new Book(12,"The Alchemist", "Paulo Coelho", 1988, Genre.FICTION, 8.5),
                new Book(13,"The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016, Genre.NON_FICTION, 8.3),
                new Book(14,"Gone Girl", "Gillian Flynn", 2012, Genre.MYSTERY, 8.1),
                new Book(15,"Fahrenheit 451", "Ray Bradbury", 1953, Genre.SCIFI, 8.4),
                new Book(16,"Pride and Prejudice", "Jane Austen", 1813, Genre.FICTION, 8.7)
        );
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return findAll()
				.stream()
				.filter(book->book.getTitle().toLowerCase().contains(title.toLowerCase()))
				.collect(Collectors.toList());
	}

}
