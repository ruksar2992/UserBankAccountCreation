package com.example.userbankaccountcreation.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.userbankaccountcreation.enumpack.StatusType;

public class UserRequestDto {
	private String userName;
	private String dateOfBirth;
	private String panNumber;
	private String mobileNumber;
	private double salary;
	@Enumerated(value = EnumType.STRING)
	private StatusType accountType;
	private String occupation;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public StatusType getAccountType() {
		return accountType;
	}

	public void setAccountType(StatusType accountType) {
		this.accountType = accountType;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
