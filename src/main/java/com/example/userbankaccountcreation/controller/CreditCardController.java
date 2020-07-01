package com.example.userbankaccountcreation.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.userbankaccountcreation.dto.CreditCardResponseDto;
import com.example.userbankaccountcreation.service.CreditCardtService;

@RestController
public class CreditCardController {
	private static Log logger = LogFactory.getLog(CreditCardController.class);

	@Autowired
	CreditCardtService creditCardService;

	@GetMapping("/user/{userId}/creditcard")
	public ResponseEntity<CreditCardResponseDto> findAccountDetails(@PathVariable("userId") int userId) {
		logger.info("Inside Searching based on userID getting  CreditCarddetails");

		CreditCardResponseDto creditCardResponseDto = creditCardService.creditCarddetails(userId);

		return new ResponseEntity<CreditCardResponseDto>(creditCardResponseDto, HttpStatus.OK);

	}
}
