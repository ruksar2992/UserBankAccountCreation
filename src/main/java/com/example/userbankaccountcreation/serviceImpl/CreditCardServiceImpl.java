package com.example.userbankaccountcreation.serviceImpl;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userbankaccountcreation.dao.CreditCardDao;
import com.example.userbankaccountcreation.dto.CreditCardResponseDto;
import com.example.userbankaccountcreation.service.CreditCardtService;
@Service
public class CreditCardServiceImpl implements CreditCardtService {

	@Autowired
	CreditCardDao  creditCardDao;
	
	@Override
	public CreditCardResponseDto creditCarddetails(int userId) {
		
	return null;
	}
	
	
	
    
	
	        
	        






}
