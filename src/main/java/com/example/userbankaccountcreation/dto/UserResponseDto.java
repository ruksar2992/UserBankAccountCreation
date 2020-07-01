package com.example.userbankaccountcreation.dto;

public class UserResponseDto {
	private char[] password;
	private int customerId;
	
	
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	

}
