package com.cg.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.dao.BookDAO;
import com.cg.book.model.Book;

@Service
public class BookServikceImpl implements BookService{

	@Autowired
	BookDAO bookDAO;
	
	
	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDAO.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.saveBook(book);
	}

	@Override
	public Book updateBook(int id,Book book) {
		
		return bookDAO.updateBook(id,book);
	}

	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		return bookDAO.deleteBook(id);
	}

	@Override
	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return bookDAO.findByTitle(title);
	}

	
}
