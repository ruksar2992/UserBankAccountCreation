package com.example.userbankaccountcreation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userbankaccountcreation.dto.LoginDto;
import com.example.userbankaccountcreation.dto.UserRequestDto;
import com.example.userbankaccountcreation.dto.UserResponseDto;
import com.example.userbankaccountcreation.service.UserService;

import com.example.userbankaccountcreation.exception.InvalidCredentialsException;

@RestController
public class UserController {

	private static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/Users")
	public ResponseEntity<UserResponseDto> registerUserDetails(@RequestBody UserRequestDto userRequestDto) {
		UserResponseDto customerDetails = userService.registeringUserDetails(userRequestDto);
		return new ResponseEntity<UserResponseDto>(customerDetails, HttpStatus.OK);
	}

	@PostMapping("/users/login")
	public String authenticateUser(@RequestBody LoginDto loginDto) throws InvalidCredentialsException {
		logger.info("authenticating the user");
		boolean isExists;
		isExists = userService.authenticateUser(loginDto.getCustomerId(), loginDto.getPassword());
		if (isExists)
			return "logged in successfully";
		else {
			return "Credentials are incorrect";
		}
	}
}
