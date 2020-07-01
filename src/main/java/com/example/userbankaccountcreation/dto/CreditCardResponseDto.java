package com.example.userbankaccountcreation.dto;

public class CreditCardResponseDto {

	private long creditCardNumber;
	private String creditCardtype;

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardtype() {
		return creditCardtype;
	}

	public void setCreditCardtype(String creditCardtype) {
		this.creditCardtype = creditCardtype;
	}

}
