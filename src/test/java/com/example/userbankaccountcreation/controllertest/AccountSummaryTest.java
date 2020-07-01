package com.example.userbankaccountcreation.controllertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.userbankaccountcreation.controller.UserController;
import com.example.userbankaccountcreation.dto.UserRequestDto;
import com.example.userbankaccountcreation.dto.UserResponseDto;
import com.example.userbankaccountcreation.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountSummaryTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	UserRequestDto userRequestDto;

	@Test
	public void registerUserDetails() {

		UserRequestDto user = new UserRequestDto();
		user.setMobileNumber("9887654321");
		user.setOccupation("employee");

		UserResponseDto user1 = new UserResponseDto();

		Mockito.when(userService.registeringUserDetails(user)).thenReturn(user1);

		ResponseEntity<UserResponseDto> responsebusdetailsdto = userController.registerUserDetails(user);
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());

	}
}
