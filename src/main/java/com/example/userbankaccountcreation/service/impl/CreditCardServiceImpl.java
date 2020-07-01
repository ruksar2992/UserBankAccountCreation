package com.example.userbankaccountcreation.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userbankaccountcreation.dao.AccountDao;
import com.example.userbankaccountcreation.dao.CreditCardDao;
import com.example.userbankaccountcreation.dao.UserDao;
import com.example.userbankaccountcreation.dto.CreditCardResponseDto;
import com.example.userbankaccountcreation.enumpack.StatusType;
import com.example.userbankaccountcreation.model.Account;
import com.example.userbankaccountcreation.model.CreditCard;
import com.example.userbankaccountcreation.model.User;
import com.example.userbankaccountcreation.service.CreditCardtService;

@Service
public class CreditCardServiceImpl implements CreditCardtService {

	@Autowired
	CreditCardDao creditCardDao;
	@Autowired
	UserDao userDao;
	@Autowired
	AccountServiceImpl accountServiceImpl;

	@Autowired
	AccountDao accountDao;

	Random rand = new Random();

	@Override
	public CreditCardResponseDto creditCarddetails(int userId) {

		CreditCardResponseDto creditCardResponseDto = new CreditCardResponseDto();
		User user = userDao.findAllByUserId(userId);
		Account account = accountDao.findAllByUserId(userId);
		CreditCard creditcard = new CreditCard();
		creditcard.setAccountId(account.getAccountId());
		creditcard.setUserId(userId);

		int creditnum = rand.nextInt(9000000) + 1000000;
		creditcard.setCreditCardNumber(creditnum);

		double salary1 = user.getSalary();
		if (salary1 > 50000) {
			creditcard.setCreditCardType("platinum");

			
		} else if ((salary1 < 50000) && (salary1 > 30000)) {
			creditcard.setCreditCardType("Gold");
		} else {
			creditcard.setCreditCardType("silver");

		}
		creditCardDao.save(creditcard);
		accountServiceImpl.saveAccountDetails(userId,StatusType.CREDITTYPE);

		CreditCard creditCard1 = creditCardDao.findAllByUserId(userId);
		creditCardResponseDto.setCreditCardNumber(creditCard1.getCreditCardNumber());
		creditCardResponseDto.setCreditCardtype(creditCard1.getCreditCardType());
		return creditCardResponseDto;
	}

}
