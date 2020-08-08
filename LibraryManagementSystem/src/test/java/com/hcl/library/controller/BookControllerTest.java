package com.hcl.library.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.library.model.Book;
import com.hcl.library.service.BookService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = BookController.class, secure = false)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	private ObjectMapper objectMapper= new ObjectMapper();

	Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
	Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
	Book mockBook3 = new Book(3, 145000, "Oracle","DB",102,"biswa",3);

	
	@Test
	@DisplayName("testSearchByISBN with valid ISBN")
	public void testSearchByISBN() throws Exception {
		when(bookService.searchByISBN(Mockito.anyInt())).thenReturn(Optional.of(mockBook1));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/isbn").accept(
						MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{bookId:1,isbn:123456,name:Java8Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:10}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		verify(bookService,times(1)).searchByISBN(Mockito.anyInt());
	}

	@Test
	@DisplayName("testSearchByName with valid Name")
	public void testSearchByName() throws Exception {
		
		when(bookService.searchByName(Mockito.anyString())).thenReturn(Optional.of(mockBook1));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/isbn").accept(
						MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{bookId:1,isbn:123456,name:Java8Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:10}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		verify(bookService,times(1)).searchByISBN(Mockito.anyInt());
	}

	@Test
	@DisplayName("testSearchByCategory with valid Category")
	public void testSearchByCategory() throws Exception {
		List<Book> bookListByCategory = new ArrayList();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookService.searchByCategory(Mockito.anyString())).thenReturn(bookListByCategory);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/isbn").accept(
						MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{bookId:1,isbn:123456,name:Java8Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:10},"
				+ "{bookId:2,isbn:123000,name:C++Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:5}]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		verify(bookService,times(1)).searchByISBN(Mockito.anyInt());
	}

	@Test
	@DisplayName("testSearchByISBN with valid RackNumber")
	public void testSearchByRackNumber() throws Exception {
		List<Book> bookListByCategory = new ArrayList();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookService.searchByRackNumber(Mockito.anyInt())).thenReturn(bookListByCategory);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/isbn").accept(
						MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{bookId:1,isbn:123456,name:Java8Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:10},"
				+ "{bookId:2,isbn:123000,name:C++Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:5}]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		verify(bookService,times(1)).searchByISBN(Mockito.anyInt());
	}

	@Test
	@DisplayName("testSearchByISBN with valid Authod")
	public void testSearchByAuthor() throws Exception {
		List<Book> bookListByCategory = new ArrayList();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookService.searchByAuthor(Mockito.anyString())).thenReturn(bookListByCategory);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/isbn").accept(
						MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{bookId:1,isbn:123456,name:Java8Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:10},"
				+ "{bookId:2,isbn:123000,name:C++Features,bookCategory:OOPS,rackNumber:101,bookAuthor:biswaranjan,noOfCopies:5}]";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		verify(bookService,times(1)).searchByISBN(Mockito.anyInt());
	}

}
