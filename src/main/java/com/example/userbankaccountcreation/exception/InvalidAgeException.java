package com.example.userbankaccountcreation.exception;

public class InvalidAgeException extends RuntimeException {

	private  final String message;
	
	
@Override
	public String getMessage() {
		return message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = -3687636533806341301L;

	public InvalidAgeException(String message) {
		super();
		this.message = message;
	}

	

}
