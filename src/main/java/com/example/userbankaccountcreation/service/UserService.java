package com.example.userbankaccountcreation.service;

import com.example.userbankaccountcreation.dto.UserRequestDto;
import com.example.userbankaccountcreation.dto.UserResponseDto;
import com.example.userbankaccountcreation.exception.InvalidCredentialsException;

public interface UserService {

	public UserResponseDto registeringUserDetails(UserRequestDto userRequestDto);

	public boolean authenticateUser(int custimerId, String string) throws InvalidCredentialsException;

}
