package com.example.userbankaccountcreation.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userbankaccountcreation.dao.AccountDao;
import com.example.userbankaccountcreation.dto.AccountResponseDto;
import com.example.userbankaccountcreation.model.Account;
import com.example.userbankaccountcreation.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	private static Log logger = LogFactory.getLog(AccountServiceImpl.class);

	@Autowired
	AccountDao accountDao;

	@Override
	public AccountResponseDto searchaccountdetails(int userId) {
		logger.info("Inside Searching based on userId getting account details");

		Account account = accountDao.findAllByUserId(userId);

		AccountResponseDto accountResponseDto = new AccountResponseDto();
		BeanUtils.copyProperties(account, accountResponseDto);
		return accountResponseDto;

	}

}
