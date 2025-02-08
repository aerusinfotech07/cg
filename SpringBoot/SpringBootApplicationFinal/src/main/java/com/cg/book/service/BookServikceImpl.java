package com.cg.book.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.dao.BookDAO;
import com.cg.book.dao.BookRepository;
import com.cg.book.model.Book;
import com.cg.dto.BookDTO;

@Service
public class BookServikceImpl implements BookService{

	@Autowired
	BookRepository bookDAO;
	
	
	@Override
	public List<BookDTO> findAll() {
		// TODO Auto-generated method stub
		return bookDAO.findAll()
				.stream()
				.map(BookDTO::new)
				.collect(Collectors.toList());
	}

	@Override
	public BookDTO saveBook(BookDTO bookDTO) {
		
		Book book=convertBookToDTO(bookDTO);
		return new BookDTO(bookDAO.save(book));
	}

	@Override
	public BookDTO updateBook(int id,BookDTO bookDTO) {
		
		Book book=convertBookToDTO(bookDTO);
		return new BookDTO(bookDAO.save(book));
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
	public List<BookDTO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return bookDAO.findByTitleContains(title)
				.stream()
				.map(BookDTO::new)
				.collect(Collectors.toList());
	}
	
	public Book convertBookToDTO(BookDTO bookRequestDTO )
	{
		 Book book = new Book();
	        book.setTitle(bookRequestDTO.getTitle());
	        book.setAuthor(bookRequestDTO.getAuthor());
	        book.setYear(bookRequestDTO.getYear());
	        book.setGenre(bookRequestDTO.getGenre());
	        book.setRating(bookRequestDTO.getRating());
	        return book;
	}

	
}
