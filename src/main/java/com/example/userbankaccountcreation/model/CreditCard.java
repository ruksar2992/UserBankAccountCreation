package com.example.userbankaccountcreation.model;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import com.example.userbankaccountcreation.Enum.CreditCardType;

@Entity
public class CreditCard {
	@Id
	private int creditCardId;
	private long creditCardNumber;
	private int accountId;
	private int UserId;
	@Enumerated(value = EnumType.STRING)
	private CreditCardType creditCardType;

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}

	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	

}
