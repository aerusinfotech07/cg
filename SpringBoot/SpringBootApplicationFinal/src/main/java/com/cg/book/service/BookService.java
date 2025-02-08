package com.cg.book.service;

import java.util.List;

import com.cg.dto.BookDTO;


public interface BookService {
	
	List<BookDTO> findAll();
	BookDTO saveBook(BookDTO book);
	BookDTO updateBook(int id,BookDTO book);
	boolean deleteBook(int id);
	List<BookDTO> findByTitle(String title);

}
