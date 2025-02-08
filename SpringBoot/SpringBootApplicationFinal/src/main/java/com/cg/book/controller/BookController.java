package com.cg.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.service.BookService;
import com.cg.dto.BookDTO;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;

	///EndPoints
	@GetMapping("/books")
	public List<BookDTO> findAll() {
		// TODO Auto-generated method stub
		return bookService.findAll();
	}
	
	@GetMapping("/findByTitle/{title}")
	public List<BookDTO> findByTitle(@PathVariable String title) {
		// TODO Auto-generated method stub
		return bookService.findByTitle(title);
	}
	
	@PostMapping("/saveBook")
	public BookDTO saveBook(@RequestBody BookDTO book)
	{		
		return bookService.saveBook(book);
	}
	
	
	@PutMapping("/updateBook/{id}")
	public BookDTO updateBook(@RequestBody BookDTO book,@PathVariable Integer id)
	{		
		return bookService.updateBook(id,book);
	}
	
	
	@DeleteMapping("/deleteBook/{id}")
	public Boolean updateBook(@PathVariable Integer id)
	{		
		return bookService.deleteBook(id);
	}
	
	
	
	
}
