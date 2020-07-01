package com.example.userbankaccountcreation.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.userbankaccountcreation.dto.AccountResponseDto;
import com.example.userbankaccountcreation.service.AccountService;

@RestController
public class AccountSummaryController {

	private static Log logger = LogFactory.getLog(AccountSummaryController.class);
	@Autowired
	AccountService accountService;

	/**
	 * @param userId
	 * @return
	 */
	@GetMapping("/user/{userId}/accountdetails")
	public ResponseEntity<AccountResponseDto> findAccountDetails(@PathVariable("userId") int userId) {
		logger.info("Inside Searching based on userId getting account details");

		AccountResponseDto accountResponseDto = accountService.searchaccountdetails(userId);

		return new ResponseEntity<AccountResponseDto>(accountResponseDto, HttpStatus.OK);

	}

}
