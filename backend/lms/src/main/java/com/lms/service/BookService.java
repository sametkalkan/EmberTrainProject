package com.lms.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import com.lms.dao.BookRepository;
import com.lms.model.Book;

@Service("bookservice")
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	
	public void save(Book book) {
		bookRepo.save(book);
	}
	public void update(Book book) {
		save(book);
	}

	/***** DELETE METHODS *****/
	public void deleteById(UUID id) {
		bookRepo.deleteById(id);
	}

	public void deleteByBook(Book book) {
		bookRepo.delete(book);
	}

	/**************************/

	/***** GETTING METHODS *****/

	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	public Book getByUuid(UUID id) {
		return bookRepo.existsById(id) ? bookRepo.findById(id).get() : null;
	}
	
	public List<Book> getByCategory(String category) {
		return bookRepo.findByCategory(category);
	}

	public Book getByIsbn(String isbn) {
		return bookRepo.existsByIsbn(isbn) ? bookRepo.findByIsbn(isbn).get() : null;
	}

	public List<Book> getBookByTitle(String title) {
		return bookRepo.findByTitle(title);
	}

	public List<Book> getBookByPublisher(String publisher) {
		return bookRepo.findByPublisher(publisher);
	}

	// public List<Book> getBookByDate(Date date) {
	// return bookRepo.findByPublishDate(date);
	// }
	/***************************/

}
