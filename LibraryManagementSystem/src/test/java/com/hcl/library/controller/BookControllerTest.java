package com.hcl.library.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hcl.library.model.Book;
import com.hcl.library.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerTest {

	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookController bookController;

	Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
	Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
	Book mockBook3 = new Book(3, 145000, "Oracle","DB",102,"biswa",3);

	@Test
	public void testInsertBook() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(bookService.insertBook(any(Book.class))).thenReturn(mockBook1);
         
        Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
        Book responseEntity = bookController.insertBook(mockBook1);
         
        assertNotNull(responseEntity);
	}
	
	@Test
	@DisplayName("testSearchByISBN with valid ISBN")
	public void testSearchByISBN() throws Exception {
		when(bookService.searchByISBN(Mockito.anyInt())).thenReturn(Optional.of(mockBook1));
		Book book = bookController.searchByISBN(123456);
		assertThat(book, is(mockBook1));
		verify(bookService,times(1)).searchByISBN(Mockito.anyInt());
	}

	@Test
	@DisplayName("testSearchByName with valid Name")
	public void testSearchByName() throws Exception {
		
		when(bookService.searchByName(Mockito.anyString())).thenReturn(Optional.of(mockBook1));
		Book book = bookController.searchByName("Java8Features");
		assertThat(book, is(mockBook1));
		verify(bookService,times(1)).searchByName(Mockito.anyString());
	}

	@Test
	@DisplayName("testSearchByCategory with valid Category")
	public void testSearchByCategory() throws Exception {
		List<Book> bookListByCategory = new ArrayList<Book>();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookService.searchByCategory(Mockito.anyString())).thenReturn(bookListByCategory);
		List<Book> bookList = bookController.searchByCategory("OOPS");
		assertThat(bookList, is(bookListByCategory));
		verify(bookService,times(1)).searchByCategory(Mockito.anyString());
	}

	@Test
	@DisplayName("testSearchByISBN with valid RackNumber")
	public void testSearchByRackNumber() throws Exception {
		List<Book> bookListByCategory = new ArrayList<Book>();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookService.searchByRackNumber(Mockito.anyInt())).thenReturn(bookListByCategory);
		List<Book> bookList = bookController.searchByRackNumber(101);
		assertThat(bookList, is(bookListByCategory));
		verify(bookService,times(1)).searchByRackNumber(Mockito.anyInt());
	}

	@Test
	@DisplayName("testSearchByISBN with valid Authod")
	public void testSearchByAuthor() throws Exception {
		List<Book> bookListByCategory = new ArrayList<Book>();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookService.searchByAuthor(Mockito.anyString())).thenReturn(bookListByCategory);
		List<Book> bookList = bookController.searchByAuthor("biswaranjan");
		assertThat(bookList, is(bookListByCategory));
		verify(bookService,times(1)).searchByAuthor(Mockito.anyString());
	}
	
	

}
