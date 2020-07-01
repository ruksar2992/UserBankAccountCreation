package com.example.userbankaccountcreation.exception;

public class InvalidAgeException extends RuntimeException{
	
	/**
	 * 
	 */
	 String message;
	private static final long serialVersionUID = -3687636533806341301L;
	
	public InvalidAgeException(String message) {
		super();
		this.message = message;
	}
	public InvalidAgeException() {
		super();
		
	}

}
