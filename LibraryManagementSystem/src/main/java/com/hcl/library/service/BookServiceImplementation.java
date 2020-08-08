package com.hcl.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.library.model.Book;
import com.hcl.library.repository.BookRepository;

@Service
public class BookServiceImplementation implements BookService{
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book insertBook(Book bookEntity) {
		return bookRepo.save(bookEntity);
	}

	@Override
	public Optional<Book> searchByISBN(Integer isbn) {
		return bookRepo.findByIsbn(isbn);
	}

	@Override
	public Optional<Book> searchByName(String bookName) {
		return bookRepo.findByName(bookName);
	}

	@Override
	public List<Book> searchByCategory(String category) {
		return bookRepo.findByBookCategory(category);
	}

	@Override
	public List<Book> searchByRackNumber(Integer rackNumber) {
		return bookRepo.findByRackNumber(rackNumber);
	}

	@Override
	public List<Book> searchByAuthor(String bookAuthor) {
		return bookRepo.findByBookAuthor(bookAuthor);
	}
	

}
