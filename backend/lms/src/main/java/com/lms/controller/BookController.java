package com.lms.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.valueextraction.UnwrapByDefault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lms.model.Book;
import com.lms.service.BookService;

@CrossOrigin
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	
	@GetMapping("/books/{id}")
	public Book getBook(@Valid @PathVariable("id") UUID id) {
		System.out.println("only request-------*-*-*-*-*");
		return bookService.getByUuid(id);
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@Valid @PathVariable("id") UUID id) {
		System.out.println("delete" + id);
		bookService.deleteById(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletee(@Valid @PathVariable("id") UUID id) {
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
	public void create(@RequestBody Book book) {
		System.out.println("POST CREATE ******************");
		String d = book.getPublishDate();
		System.out.println(d);
		book.setId(UUIDs.timeBased());
		bookService.save(book);
	}

}
