package com.hcl.library.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hcl.library.model.Book;
import com.hcl.library.repository.BookRepository;

public class BookServiceImplementationTest {

	@Mock
	private BookRepository bookRepo;
	
	@InjectMocks
	private BookServiceImplementation bookService;
	
	 @BeforeEach
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);
	    }

	 @Test
	 public void testsearchByISBN() {
		 Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		 when(bookRepo.findByIsbn(1)).thenReturn(Optional.of(mockBook1));
	        //When
	        Optional<Book> book = bookService.searchByISBN(1);
	        //Then
	        assertNotNull(book.get());
	      
	        verify(bookRepo,times(1)).findByIsbn(1);
		 
	 }
	 
	 @Test
	 public void testSearchByName() {
		 Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		 when(bookRepo.findByName("Java8Features")).thenReturn(Optional.of(mockBook1));
	        //When
	        Optional<Book> book = bookService.searchByName("Java8Features");
	        //Then
	        assertNotNull(book.get());
	      
	        verify(bookRepo,times(1)).findByName("Java8Features");
		 
	 }
	 
	 @Test
	 public void testSearchByCategory() {
		 Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		 Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
		 List<Book> bookListByCategory = new ArrayList<Book>();
			bookListByCategory.add(mockBook1);
			bookListByCategory.add(mockBook2);
			System.out.println("List Size--" + bookListByCategory.size());
		 when(bookRepo.findByBookCategory("OOPS")).thenReturn(bookListByCategory);
	        //When
	        List<Book> bookList= bookService.searchByCategory("OOPS");
	        //Then
	        assertNotNull(bookList);
	      
	        verify(bookRepo,times(1)).findByBookCategory("OOPS");
		 
	 }
	 
	 @Test
	 public void testSearchByRackNumber() {
		 Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		 Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
		 List<Book> bookListByCategory = new ArrayList();
			bookListByCategory.add(mockBook1);
			bookListByCategory.add(mockBook2);
		 when(bookRepo.findByRackNumber(101)).thenReturn(bookListByCategory);
	        //When
	        List<Book> bookList= bookService.searchByRackNumber(101);
	        //Then
	        assertNotNull(bookList);
	      
	        verify(bookRepo,times(1)).findByRackNumber(101);
		 
	 }
	 
	 @Test
	 public void testSearchByAuthor() {
		 Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		 Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
		 List<Book> bookListByCategory = new ArrayList();
			bookListByCategory.add(mockBook1);
			bookListByCategory.add(mockBook2);
		 when(bookRepo.findByBookAuthor("biswaranjan")).thenReturn(bookListByCategory);
	        //When
	        List<Book> bookList= bookService.searchByAuthor("biswaranjan");
	        //Then
	        assertNotNull(bookList);
	      
	        verify(bookRepo,times(1)).findByBookAuthor("biswaranjan");
		 
	 }
}
