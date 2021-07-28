package com.cg.bookstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.service.BookServiceImpl;

@WebMvcTest(BookController.class)
public class BookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean                       
	private BookServiceImpl bookService;
	
	@MockBean                       
	private IBookRepository Book;
	
	@Test
	public void testgetBooks() throws Exception {
		List<Book> listBooks=new ArrayList<>();
		listBooks.add(new Book());
		Mockito.when(bookService.listAllBooks()).thenReturn(listBooks);
		String url="/getallbooks";
		mockMvc.perform(get(url)).andExpect(status().isOk());
		
	}
}
