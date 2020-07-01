package com.example.userbankaccountcreation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userbankaccountcreation.dto.UserRequestDto;
import com.example.userbankaccountcreation.dto.UserResponseDto;
import com.example.userbankaccountcreation.service.UserService;



@RestController
public class UserController {
	@Autowired
	UserService userService;

	
	@PostMapping("/trains")
	public ResponseEntity<UserResponseDto> registerUserDetails(@RequestBody UserRequestDto userRequestDto) {
		UserResponseDto customerDetails = userService.registeringUserDetails(userRequestDto);
		return new ResponseEntity<UserResponseDto>(customerDetails, HttpStatus.OK);
	}

}
