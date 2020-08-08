package com.hcl.library.service;

import java.util.List;
import java.util.Optional;

import com.hcl.library.model.Book;

public interface BookService {
	
	public Book insertBook(Book bookEntity); 
	
	public Optional<Book> searchByISBN(Integer isbn);
	
	public Optional<Book> searchByName(String bookName);
	
	public List<Book> searchByCategory(String category);
	
	public List<Book> searchByRackNumber(Integer rackNumber);
	
	public List<Book> searchByAuthor(String bookAuthor);
}
