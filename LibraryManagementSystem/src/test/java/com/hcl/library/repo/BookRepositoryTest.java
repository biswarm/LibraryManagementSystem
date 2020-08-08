/*package com.hcl.library.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.hcl.library.model.Book;
import com.hcl.library.repository.BookRepository;



public class BookRepositoryTest {

	@Mock
	private BookRepository bookRepository;


	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createBook_whenBookDataIsValid_ReturnCreatedBookId(){
		//Given
		Book bookEntity = new Book();
		bookEntity.setBookId(1);
		when(bookRepository.save(Mockito.any(Book.class))).thenReturn(bookEntity);
		//When
		Book book = bookRepository.save(bookEntity);
		//Then
		assertNotNull(book.getBookId());
		verify(bookRepository,times(1)).save(Mockito.any(Book.class));
	}
	
	@Test
	public void getBookBasedOnISBN() {
		Book bookEntity = new Book();
		bookEntity.setBookId(1);
		bookEntity.setIsbn(123456);
		when(bookRepository.findByIsbn(1)).thenReturn(Optional.of(bookEntity));
		
		Optional<Book> book = bookRepository.findByIsbn(bookEntity.getIsbn());
		assertNotNull(book.get());
	}
	
	
	@Test
	public void getBookBasedOnName() {
		Book bookEntity = new Book();
		bookEntity.setBookId(1);
		bookEntity.setIsbn(123456);
		bookEntity.setName("Java8Features");
		when(bookRepository.findByName("Java8Features")).thenReturn(Optional.of(bookEntity));
		
		Optional<Book> book = bookRepository.findByName(bookEntity.getName());
		assertNotNull(book.get());
	}
}
*/