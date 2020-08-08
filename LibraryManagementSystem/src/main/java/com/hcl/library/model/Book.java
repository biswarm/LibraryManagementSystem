package com.hcl.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="BOOK")
public class Book {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	@Column
	private Integer isbn;
	@Column
	private String name;
	@Column
	private String bookCategory;
	@Column
	private Integer rackNumber;
	@Column
	private String bookAuthor;
	@Column
	private Integer noOfCopies;
	
	public Book() {
		
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	
	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public Integer getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(Integer rackNumber) {
		this.rackNumber = rackNumber;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public Book(Integer bookId, Integer isbn, String name, String bookCategory, Integer rackNumber, String bookAuthor,
			Integer noOfCopies) {
		this.bookId = bookId;
		this.isbn = isbn;
		this.name = name;
		this.bookCategory = bookCategory;
		this.rackNumber = rackNumber;
		this.bookAuthor = bookAuthor;
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", name=" + name + ", bookCategory=" + bookCategory
				+ ", rackNumber=" + rackNumber + ", bookAuthor=" + bookAuthor + ", noOfCopies=" + noOfCopies + "]";
	}

	
}
