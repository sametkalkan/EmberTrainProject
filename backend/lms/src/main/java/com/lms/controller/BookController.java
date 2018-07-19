package com.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Book;
import com.lms.service.BookService;

@CrossOrigin
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books/category/{category}")
	public List<Book> getBooksByCategory(@Valid @PathVariable("category") String category) {
		return bookService.getBookByCategory(category);
	}

	@GetMapping("/books/title/{title}")
	public List<Book> getBooksByTitle(@Valid @PathVariable("title") String title) {
		return bookService.getBookByTitle(title);
	}
	
	@GetMapping("/books/author/{author}")
	public List<Book> getBooksByAuthor(@Valid @PathVariable("author") String author) {
		return bookService.getBookByAuthor(author);
	}

	@GetMapping("/books/{id}")
	public Book getBook(@Valid @PathVariable("id") int id) {
		System.out.println("only request-------*-*-*-*-*");
		return bookService.getById(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletee(@Valid @PathVariable("id") int id) {
		System.out.println("delet-**********************************************e" + id);
		bookService.deleteById(id);
	}

	@GetMapping("books")
	public List<Book> getAllBooks() {
		System.out.println("geldi------------------");
		return bookService.getAll();
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody Book book) {
		System.out.println("sdfsdf");
		bookService.update(book);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Book book) {
		System.out.println("POST CREATE ******************");
		List<Book> b = bookService.getBookByTitle(book.getTitle());
		if(b.size()>0) {
			return new ResponseEntity(new String("The title already exists."), HttpStatus.BAD_REQUEST);
		}
		bookService.save(book);
		return new ResponseEntity<String>(new String("New book has been created."), HttpStatus.CREATED);
	}

}
