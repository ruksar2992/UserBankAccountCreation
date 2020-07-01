package com.example.userbankaccountcreation.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.userbankaccountcreation.dao.AccountDao;
import com.example.userbankaccountcreation.dto.AccountResponseDto;
import com.example.userbankaccountcreation.model.AccountSummary;
import com.example.userbankaccountcreation.serviceimpl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)

public class AccountServiceTest {
	 AccountSummary  accountSummary;
		
		@Mock
		AccountDao accountDao;
		
		@InjectMocks
		AccountServiceImpl accountServiceImpl;
		
		AccountResponseDto accountResponsedto;
		@BeforeEach
		public void setUp()
		{
			
			accountSummary=new AccountSummary();
			accountSummary.setAccountType("savings");
			accountSummary.setBalance(500);
						
		}
		@Test
		public void searchaccountdetails()
		{
			
			when(accountDao.findAllByUserId(1)).thenReturn(accountSummary);
			
			
			
			accountServiceImpl.searchaccountdetails(1);
			
			
			verify(accountDao).findAllByUserId(1);
		}
			
		}
		



