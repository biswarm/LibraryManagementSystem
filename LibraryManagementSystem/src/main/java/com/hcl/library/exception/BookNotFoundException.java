package com.hcl.library.exception;

public class BookNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;
    public BookNotFoundException(String message) {
        this.message = message;
    }

}
