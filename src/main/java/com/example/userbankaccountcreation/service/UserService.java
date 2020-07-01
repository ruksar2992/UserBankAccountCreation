package com.example.userbankaccountcreation.service;


import com.example.userbankaccountcreation.exception.InvalidCredentialsException;

public interface UserService {
/**
	 * This method is used to authenticate User
	 * @param loginDto
	 * @return boolean true if an authenticated User else false
	 * @throws InvalidCredentialsException 
	 */
	public boolean authenticateUser(int custimerId, String password) throws InvalidCredentialsException;
}
