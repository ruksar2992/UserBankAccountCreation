package com.example.userbankaccountcreation.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userbankaccountcreation.dao.AccountDao;
import com.example.userbankaccountcreation.dao.CreditCardDao;
import com.example.userbankaccountcreation.dao.UserDao;
import com.example.userbankaccountcreation.dto.CreditCardResponseDto;
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
	AccountDao accountDao;

	@Override
	public CreditCardResponseDto creditCarddetails(int userId) {

		CreditCardResponseDto creditCardResponseDto = new CreditCardResponseDto();
		User user = userDao.findAllByUserId(userId);
		Account account = accountDao.findAllByUserId(userId);
		CreditCard creditcard = new CreditCard();
		creditcard.setAccountId(account.getAccountId());
		creditcard.setUserId(userId);

		Random rand = new Random();
		int creditnum = rand.nextInt(9000000) + 1000000;
		creditcard.setCreditCardNumber(creditnum);

		double salary1 = user.getSalary();
		if (salary1 > 50000) {
			creditcard.setCreditCardType("platinum");

			creditCardDao.save(creditcard);

		} else if ((salary1 < 50000) && (salary1 > 30000)) {
			creditcard.setCreditCardType("Gold");
			creditCardDao.save(creditcard);
		} else {
			creditcard.setCreditCardType("silver");
			creditCardDao.save(creditcard);

		}
		CreditCard creditCard1 = creditCardDao.findAllByUserId(userId);
		creditCardResponseDto.setCreditCardNumber(creditCard1.getCreditCardNumber());
		creditCardResponseDto.setCreditCardtype(creditCard1.getCreditCardType());
		return creditCardResponseDto;
	}

}
