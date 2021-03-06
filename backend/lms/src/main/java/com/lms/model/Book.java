package com.lms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.Size;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table("book")
public class Book {

	@PrimaryKey
	private UUID id;

	@Size(min=10, max=16)
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String category;
	private String publishDate;
	private int npage;

	public Book() {

	}

	public Book(UUID id, String isbn, String title, String author, String publisher, String category,
			String publishDate, int npage) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.publishDate = publishDate;
		this.npage = npage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getNpage() {
		return npage;
	}

	public void setNpage(int npage) {
		this.npage = npage;
	}

}
