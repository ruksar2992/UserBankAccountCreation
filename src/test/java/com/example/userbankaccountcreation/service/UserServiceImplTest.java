package com.example.userbankaccountcreation.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.userbankaccountcreation.dao.UserDao;
import com.example.userbankaccountcreation.dto.LoginDto;
import com.example.userbankaccountcreation.exception.InvalidCredentialsException;
import com.example.userbankaccountcreation.model.User;
import com.example.userbankaccountcreation.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	User user;

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	LoginDto loginDto;

	@Test
	public void authenticateTest() {
		// given
		User user = new User();
		user.setCustomerId(1);

		when(userDao.findByCustomerIdAndPassword(1, "ruksar")).thenReturn(null);

		// when

		// then
		assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticateUser(1, "ruksar"));
	}

}
