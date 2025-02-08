package com.cg.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.dao.BookDAO;
import com.cg.book.dao.BookRepository;
import com.cg.book.model.Book;

@Service
public class BookServikceImpl implements BookService{

	@Autowired
	BookRepository bookDAO;
	
	
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDAO.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.save(book);
	}

	@Override
	public Book updateBook(int id,Book book) {
		
		return bookDAO.save(book);
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		Optional<Book> book=bookDAO.findById(id);
		if(book.isPresent())
		{
			bookDAO.delete(book.get());
			return true;
		}
		return false;
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return bookDAO.findByTitleContains(title);
	}

	
}
