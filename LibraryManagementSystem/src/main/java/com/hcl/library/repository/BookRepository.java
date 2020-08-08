package com.hcl.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	Optional<Book> findByIsbn(Integer isbn);
	
	Optional<Book> findByName(String name);
	
	List<Book> findByBookCategory(String bookCategory);
	
	List<Book> findByRackNumber(Integer rackNumber);
	
	List<Book> findByBookAuthor(String bookAuthor);
	
	
}
