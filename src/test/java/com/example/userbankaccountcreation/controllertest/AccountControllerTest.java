package com.example.userbankaccountcreation.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.userbankaccountcreation.controller.AccountSummaryController;
import com.example.userbankaccountcreation.dto.AccountResponseDto;
import com.example.userbankaccountcreation.service.AccountService;


@ExtendWith(MockitoExtension.class)

public class AccountControllerTest {
	@InjectMocks
	AccountSummaryController accountSummaryController;

	@Mock
	AccountService accountService;
	
	
	@Test

	public void findRoomDetails() {
		
		AccountResponseDto account = new AccountResponseDto();
		account.setBalance(5000);
		
		
		

		Mockito.when(accountService.searchaccountdetails(1)).thenReturn(Mockito.any());

		ResponseEntity<AccountResponseDto> responsebusdetailsdto = accountSummaryController.findAccountDetails(1);
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());



	}

	

}
