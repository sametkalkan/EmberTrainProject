package com.lms.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lms.model.Book;

@Repository
public interface BookRepository extends CassandraRepository<Book, UUID> {

	@Query("SELECT * FROM book")
	List<Book> findAll();

	@Query("SELECT * FROM book WHERE id=:id")
	Optional<Book> findById(@Param("id") UUID id);

	@Query("SELECT * FROM book WHERE title=:title ALLOW FILTERING")
	List<Book> findByTitle(@Param("title") String title);

	@Query("SELECT * FROM book WHERE author=:author ALLOW FILTERING")
	List<Book> findByAuthor(@Param("author") String author);

	@Query("SELECT * FROM book WHERE publisher=:publisher ALLOW FILTERING")
	List<Book> findByPublisher(@Param("title") String publisher);

	@Query("SELECT * FROM book WHERE publishDate=:publishDate ALLOW FILTERING")
	List<Book> findByPublishDate(@Param("title") String date);

	@Query("SELECT * FROM book WHERE category=:category ALLOW FILTERING")
	List<Book> findByCategory(@Param("category") String category);

	boolean existsByIsbn(String isbn);

	@Query("SELECT * FROM book WHERE publishDate=:publishDate ALLOW FILTERING")
	Optional<Book> findByIsbn(@Param("isbn") String isbn);

	@Query("DELETE FROM book WHERE id=:id")
	void deleteById(@Param("id") UUID id);

}
