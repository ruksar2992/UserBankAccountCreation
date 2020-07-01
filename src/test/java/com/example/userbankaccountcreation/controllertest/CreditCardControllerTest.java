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

import com.example.userbankaccountcreation.controller.CreditCardController;
import com.example.userbankaccountcreation.dto.CreditCardResponseDto;
import com.example.userbankaccountcreation.service.CreditCardtService;


@ExtendWith(MockitoExtension.class)

public class CreditCardControllerTest {
	@InjectMocks
	CreditCardController creditCardController;
	@Mock
	CreditCardtService creditCardtService;
	
	
	@Test

	public void findAccountDetails() {
		
	CreditCardResponseDto creditCardResponseDto=new CreditCardResponseDto();
		
	creditCardResponseDto.setCreditCardNumber(54458555);
	creditCardResponseDto.setCreditCardtype("gold");

		Mockito.when(creditCardtService.creditCarddetails(1)).thenReturn(Mockito.any());

		ResponseEntity<CreditCardResponseDto> creditCardResponseDto1 = creditCardController.findAccountDetails(1);
		assertEquals(HttpStatus.OK, creditCardResponseDto1.getStatusCode());



	}

	

}

