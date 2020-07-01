package com.example.userbankaccountcreation.serviceimpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userbankaccountcreation.dao.UserDao;
import com.example.userbankaccountcreation.exception.InvalidCredentialsException;
import com.example.userbankaccountcreation.model.User;
import com.example.userbankaccountcreation.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	UserDao userDao;
	
	/**
	 * {@inheritDoc}
	 * 
	 * @throws InvalidCredentialsException
	 */

	@Override
	public boolean authenticateUser(int custimerId, String password) throws InvalidCredentialsException {
		logger.info("implementaion of authenticating the user");
		User user = userDao.findByCustomerIdAndPassword(custimerId, password);
		
		if (user != null)
		return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials");
	}
	
		

}
