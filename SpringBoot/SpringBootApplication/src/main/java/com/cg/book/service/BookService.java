package com.cg.book.service;

import java.util.List;

import com.cg.book.model.Book;

public interface BookService {
	
	List<Book> findAll();
	Book saveBook(Book book);
	Book updateBook(int id,Book book);
	boolean deleteBook(int id);
	List<Book> findByTitle(String title);

}
