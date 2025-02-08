package com.cg.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.model.Book;
import com.cg.book.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;

	///EndPoints
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
	
	@PostMapping("/saveBook")
	public Book saveBook(@RequestBody Book book)
	{		
		return bookService.saveBook(book);
	}
	
	
	@PutMapping("/updateBook/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable Integer id)
	{		
		return bookService.updateBook(id,book);
	}
	
	
	
	
	
	
}
