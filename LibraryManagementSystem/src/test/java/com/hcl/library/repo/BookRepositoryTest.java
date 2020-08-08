package com.hcl.library.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.library.model.Book;
import com.hcl.library.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
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
	public void getBookBasedOnISBNTest() {
		Book bookEntity = new Book();
		bookEntity.setBookId(1);
		bookEntity.setIsbn(123456);
		when(bookRepository.findByIsbn(Mockito.anyInt())).thenReturn(Optional.of(bookEntity));
		
		Optional<Book> book = bookRepository.findByIsbn(bookEntity.getIsbn());
		assertNotNull(book.get());
	}
	
	
	@Test
	public void getBookBasedOnNameTest() {
		Book bookEntity = new Book();
		bookEntity.setBookId(1);
		bookEntity.setIsbn(123456);
		bookEntity.setName("Java8Features");
		when(bookRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(bookEntity));
		
		Optional<Book> book = bookRepository.findByName(bookEntity.getName());
		assertNotNull(book.get());
	}
	
	@Test
	public void findByBookCategoryTest() {
		Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
		List<Book> bookListByCategory = new ArrayList<Book>();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		
		when(bookRepository.findByBookCategory(Mockito.anyString())).thenReturn(bookListByCategory);
		List<Book> bookList = bookRepository.findByBookCategory(mockBook1.getBookCategory());
		assertNotNull(bookList);
	}
	
	@Test
	public void findByRackNumberTest() {
		Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
		List<Book> bookListByCategory = new ArrayList<Book>();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookRepository.findByRackNumber(Mockito.anyInt())).thenReturn(bookListByCategory);
		List<Book> bookList = bookRepository.findByRackNumber(mockBook1.getRackNumber());
		assertNotNull(bookList);
	}
	
	@Test
	public void findByBookAuthorTest() {
		Book mockBook1 = new Book(1, 123456, "Java8Features","OOPS",101,"biswaranjan",10);
		Book mockBook2 = new Book(2, 123000, "C++Features","OOPS",101,"biswaranjan",5);
		List<Book> bookListByCategory = new ArrayList<Book>();
		bookListByCategory.add(mockBook1);
		bookListByCategory.add(mockBook2);
		when(bookRepository.findByBookAuthor(Mockito.anyString())).thenReturn(bookListByCategory);
		
		List<Book> bookList = bookRepository.findByBookAuthor(mockBook1.getBookAuthor());
		assertNotNull(bookList);
	}
}
