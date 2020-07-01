package com.example.userbankaccountcreation.dao;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

import com.google.common.base.Optional;




public interface CreditCardDao extends CrudRepository<User, Integer> {

	
	public Optional<User> findByUserId(Long userId);

}
