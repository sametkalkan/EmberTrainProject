package com.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.Book;

@Repository
public interface BookRepositoryMySql extends JpaRepository<Book, Integer>{

	List<Book> findByCategory(String category);

	boolean existsByIsbn(String isbn);

	Optional<Book> findByIsbn(String isbn);

	List<Book> findByTitleContaining(String title);

	List<Book> findByAuthorContaining(String author);

	List<Book> findByPublisherContaining(String publisher);
	
	List<Book> findByCategoryContaining(String publisher);
	

}
