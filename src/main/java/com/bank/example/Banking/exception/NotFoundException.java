package com.bank.example.Banking.exception;

import org.springframework.stereotype.Component;

@Component
public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public NotFoundException() {
	super();
}
public NotFoundException(String string) {
	// TODO Auto-generated constructor stub
}

}
