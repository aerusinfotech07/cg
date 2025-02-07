package com.cg.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.model.Book;
import com.cg.book.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookService.findAll();
	}
	
	@GetMapping("/findByTitle/{title}")
	public List<Book> findByTitle(@PathVariable String title) {
		// TODO Auto-generated method stub
		return bookService.findByTitle(title);
	}
	
}
