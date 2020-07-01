package com.example.userbankaccountcreation.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userbankaccountcreation.dao.AccountDao;
import com.example.userbankaccountcreation.dao.UserDao;
import com.example.userbankaccountcreation.dto.UserRequestDto;
import com.example.userbankaccountcreation.dto.UserResponseDto;
import com.example.userbankaccountcreation.exception.InvalidAgeException;
import com.example.userbankaccountcreation.exception.InvalidCredentialsException;
import com.example.userbankaccountcreation.model.User;
import com.example.userbankaccountcreation.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserDao userDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	AccountServiceImpl accountServiceImpl;
	Random rand = new Random();
	Random random = new Random();

	

	@Override
	public UserResponseDto registeringUserDetails(UserRequestDto userRequestDto) {

		User user = new User();
		UserResponseDto userResponseDto = new UserResponseDto();
		LocalDate birthDate = LocalDate.parse(userRequestDto.getDateOfBirth());
		int age = Period.between(birthDate, LocalDate.now()).getYears();
		if (age >= 18) {
			user.setUserName(userRequestDto.getUserName());
			user.setSalary(userRequestDto.getSalary());
			user.setDateOfBirth(birthDate);
			user.setMobileNumber(userRequestDto.getMobileNumber());
			user.setPanNumber(userRequestDto.getPanNumber());
			user.setOccupation(userRequestDto.getOccupation());

			int customernum = rand.nextInt(9000000) + 1000000;
			user.setCustomerId(customernum);
			char[] customerPassword = generatePassword(8);
			
			String cusPassword = Arrays.toString(customerPassword);
			user.setPassword(cusPassword);
			userDao.save(user);
			User userdetail = userDao.findUserIdByPanNumber(userRequestDto.getPanNumber());
			accountServiceImpl.saveAccountDetails(userdetail.getUserId(),userRequestDto.getAccountType() );
			userResponseDto.setCustomerId(customernum);
			userResponseDto.setPassword(cusPassword);
			return userResponseDto;
		}

		else {
			throw new InvalidAgeException(
					"your Age is Not sufficient for creating Account.Age shoule be greater than or equal to 18");
		}
	}
	
	public char[] generatePassword(int length) {
		
		
		
		
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		
		char[] password = new char[8];

		password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		password[3] = numbers.charAt(random.nextInt(numbers.length()));

		for (int i = 4; i < 8; i++) {
			password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		}
		return password;

	}

	@Override
	public boolean authenticateUser(int custimerId, String password) throws InvalidCredentialsException {
		logger.info("implementaion of authenticating the user");
		User user = userDao.findByCustomerIdAndPassword(custimerId, password);

		if (user != null)
			return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials");
	}
}
