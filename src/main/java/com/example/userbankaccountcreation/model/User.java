package com.example.userbankaccountcreation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	public int customerId;
	public String password;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}