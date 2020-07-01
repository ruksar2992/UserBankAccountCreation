package com.example.userbankaccountcreation.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userbankaccountcreation.dto.LoginDto;
import com.example.userbankaccountcreation.exception.InvalidCredentialsException;
import com.example.userbankaccountcreation.service.UserService;


@RestController
public class UserController {

	private static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	UserService userService;

	
	/**
	 * This method is used to authenticate the user 
	 * @param loginDto
	 * @return String
	 * @throws InvalidCredentialsException
	 */
	@PostMapping("/users/login")
	public String authenticateUser(@RequestBody LoginDto loginDto) throws InvalidCredentialsException {
		logger.info("authenticating the user");
		boolean isExists;
		isExists=userService.authenticateUser(loginDto.getCustomerId(),loginDto.getPassword());
		if (isExists)
			return "logged in successfully";
		else {
			return "Credentials are incorrect";
		}
	}
	
}
