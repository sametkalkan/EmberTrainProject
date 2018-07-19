package com.lms;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.model.Book;
import com.lms.service.BookService;

public class TestWebApp extends LmsApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private BookService bookService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		// System.out.println("before");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	
	/* TEST FOR POST METHODS */
	
	@Test
	public void testCreateBook() throws Exception {
		Book newBook = new Book();
		newBook.setAuthor("Omer sdasd");
		newBook.setCategory("Story");
		newBook.setIsbn("4562341239763");
		newBook.setNpage(452);
		newBook.setPublishDate("1999.07.07");
		newBook.setPublisher("Dost");
		newBook.setTitle("Harry Potter and the prisoner of Azkaban");
		
		ResultActions ra = mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
									   .content(asJsonString(newBook)));
		String responseMessage = ra.andReturn().getResponse().getContentAsString();
		
		Assert.assertSame("Test Create Book: ", "The title already exists.", responseMessage);
	}

	@Test
	public void testUpdateBook() throws Exception {
		
		Book newBook = new Book();
		newBook.setId( 1 );
		newBook.setAuthor("Omer Seyfettin");
		newBook.setCategory("Story");
		newBook.setIsbn("4562341239763");
		newBook.setNpage(452);
		newBook.setPublishDate("1999.07.07");
		newBook.setPublisher("Dost");
		newBook.setTitle("Perili Kosk");
		
		mockMvc.perform(post("/update").contentType(MediaType.APPLICATION_JSON)
									   .content(asJsonString(newBook)));
	}
	
	/* ********************* */


	/* TEST FOR DELETE METHOD */
	@Test
	public void testDeleteId() throws Exception {
		String id = "13c13430-85d4-11e8-b969-57071d8b7025";
		mockMvc.perform(delete("/delete/" + id));
	}
	/* *********************** */

	/* TEST FOR GET METHODS */
	@Test
	public void testGetByTitle() throws Exception {
		String title = "harry";
		List<Book> books = bookService.getBookByTitle(title);

		mockMvc.perform(get("/books/title/" + title));

		for (Book book : books) {
			System.out.println(book.getTitle());
		}
	}

	@Test
	public void testGetByCategory() throws Exception {
		String category = "Fantastic";
		List<Book> books = bookService.getBookByCategory(category);

		mockMvc.perform(get("/books/category/" + category));
		
		
	}

	@Test
	public void testGetAllBooks() throws Exception {
		mockMvc.perform(get("/books"));
	}

	@Test
	public void testGetOneBook() throws Exception {
		String id = "28e61b10-8673-11e8-b3e8-4f7bc0332bad";
		mockMvc.perform(get("/books/" + id));
	}
	/* ***************************** */

	@After
	public void tearDown() {
		// System.out.println("after");
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
