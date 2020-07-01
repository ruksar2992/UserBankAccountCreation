package com.example.userbankaccountcreation.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userbankaccountcreation.dao.AccountDao;
import com.example.userbankaccountcreation.dao.UserDao;
import com.example.userbankaccountcreation.dto.UserRequestDto;
import com.example.userbankaccountcreation.dto.UserResponseDto;
import com.example.userbankaccountcreation.exception.InvalidAgeException;
import com.example.userbankaccountcreation.model.Account;
import com.example.userbankaccountcreation.model.User;
import com.example.userbankaccountcreation.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	AccountDao accountDao;

	@Override
	public UserResponseDto registeringUserDetails(UserRequestDto userRequestDto) {
		
		User user = new User();
	Account account = new Account();
	UserResponseDto UserResponseDto = new  UserResponseDto(); 
		LocalDate birthDate = LocalDate.parse(userRequestDto.getDateOfBirth());
		int age=Period.between(birthDate,LocalDate.now()).getYears();
		if(age>=18) {
			user.setUserName(userRequestDto.getUserName());
			user.setSalary(userRequestDto.getSalary());
			user.setDateOfBirth(birthDate);
			user.setMobileNumber(userRequestDto.getMobileNumber());
			user.setPanNumber(userRequestDto.getPanNumber());
			user.setOccupation(userRequestDto.getOccupation());
			Random rand = new Random();
			int customernum = rand.nextInt(9000000) + 1000000;
			user.setCustomerId(customernum);
			char[] customerPassword=generatePassword(8);
            user.setPassword(customerPassword);
            userDao.save(user);
            User userdetail = userDao.findUserIdByPanNumber(userRequestDto.getPanNumber());
            long accountNum = ThreadLocalRandom.current().nextLong(100000000,999999999);
			account.setAccountNumber(accountNum);
			account.setBalance(5000);
			account.setAccountType(userRequestDto.getAccountType());
			account.setUserId(userdetail.getUserId());
			accountDao.save(account);
			UserResponseDto.setCustomerId(customernum);
			UserResponseDto.setPassword(customerPassword);
			return UserResponseDto;
}
		
		else {
			throw new InvalidAgeException("your Age is Not sufficient for creating Account.Age shoule be greater than or equal to 18");
		}
	}

	private static char[] generatePassword(int length) {
		 String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[8];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< 8 ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password;

}
}
