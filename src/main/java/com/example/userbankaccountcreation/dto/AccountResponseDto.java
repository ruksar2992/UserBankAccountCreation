package com.example.userbankaccountcreation.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.userbankaccountcreation.enumpack.StatusType;

public class AccountResponseDto {
	private long accountNumber;
	private double balance;
	@Enumerated(value = EnumType.STRING)
	private StatusType accountType;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public StatusType getAccountType() {
		return accountType;
	}

	public void setAccountType(StatusType accountType) {
		this.accountType = accountType;
	}

}
