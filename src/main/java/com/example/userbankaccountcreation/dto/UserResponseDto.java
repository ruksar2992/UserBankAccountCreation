package com.example.userbankaccountcreation.dto;

public class UserResponseDto {
	private String password;
	private int customerId;

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
