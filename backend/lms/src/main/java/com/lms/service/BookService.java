package com.lms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.BookRepositoryMySql;
import com.lms.model.Book;

@Service("bookservice")
public class BookService {

	@Autowired
	private BookRepositoryMySql bookRepo;
	// private BookRepository bookRepo;

	public void save(Book book) {
		bookRepo.save(book);
	}

	public void update(Book book) {
		save(book);
	}

	/***** DELETE METHODS *****/
	public void deleteById(int id) {
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

	public Book getById(int id) {
		return bookRepo.existsById(id) ? bookRepo.findById(id).get() : null;
	}

	public List<Book> getByCategory(String category) {
		return bookRepo.findByCategory(category);
	}

	public Book getByIsbn(String isbn) {
		return bookRepo.existsByIsbn(isbn) ? bookRepo.findByIsbn(isbn).get() : null;
	}

	public List<Book> getBookByTitle(String title) {
		return bookRepo.findByTitleContaining(title);
	}

	public List<Book> getBookByAuthor(String author) {
		return bookRepo.findByAuthorContaining(author);
	}

	public List<Book> getBookByCategory(String category) {
		return bookRepo.findByCategoryContaining(category);
	}

	public List<Book> getBookByPublisher(String publisher) {
		return bookRepo.findByPublisherContaining(publisher);
	}

}
