package com.hcl.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.library.exception.BookNotFoundException;
import com.hcl.library.model.Book;
import com.hcl.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value="/insertBook")
	public Book insertBook(@RequestBody Book bookEntity) {

		Book book = bookService.insertBook(bookEntity);
		return book;

	}

	@GetMapping(value="/searchByIsbn/{isbn}")
	public Book searchByISBN(@PathVariable Integer isbn) throws BookNotFoundException {
		Optional<Book> book = bookService.searchByISBN(isbn);
		if(book.isPresent()) {
			return book.get();
		}else {
			throw new BookNotFoundException("Book Not Found!!!");
		}

	}


	@GetMapping(value="/searchByBookName/{bookName}")
	public Book searchByName(@PathVariable String bookName) throws BookNotFoundException {
		Optional<Book> book = bookService.searchByName(bookName);
		if(book.isPresent()) {
			return book.get();
		}else {
			throw new BookNotFoundException("Book Not Found!!!");
		}


	}

	@GetMapping(value="/searchByCategory/{category}")
	public List<Book> searchByCategory(@PathVariable String category) throws BookNotFoundException {
		List<Book> bookList = bookService.searchByCategory(category);
		if(!bookList.isEmpty()) {
			return bookList;
		}else {
			throw new BookNotFoundException("Book Not Found!!!");
		}

	}


	@GetMapping(value="/searchByRackNumber/{rackNumber}")
	public List<Book> searchByRackNumber(@PathVariable Integer rackNumber) throws BookNotFoundException {
		List<Book> bookList = bookService.searchByRackNumber(rackNumber);
		if(!bookList.isEmpty()) {
			return bookList;
		}else {
			throw new BookNotFoundException("Book Not Found!!!");
		}

	}

	@GetMapping(value="/searchByBookAuthor/{bookAuthor}")
	public List<Book> searchByAuthor(@PathVariable String bookAuthor) throws BookNotFoundException {
		List<Book> bookList = bookService.searchByAuthor(bookAuthor);
		if(!bookList.isEmpty()) {
			return bookList;
		}else {
			throw new BookNotFoundException("Book Not Found!!!");
		}


	}

}
