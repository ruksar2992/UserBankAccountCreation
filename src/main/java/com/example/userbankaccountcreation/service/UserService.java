package com.example.userbankaccountcreation.service;

import com.example.userbankaccountcreation.dto.UserRequestDto;
import com.example.userbankaccountcreation.dto.UserResponseDto;

public interface UserService {

	public UserResponseDto registeringUserDetails(UserRequestDto userRequestDto);
		

}
