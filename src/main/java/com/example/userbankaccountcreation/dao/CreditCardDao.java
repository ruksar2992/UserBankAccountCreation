package com.example.userbankaccountcreation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userbankaccountcreation.model.User;
import com.google.common.base.Optional;



@Repository
public interface CreditCardDao extends CrudRepository<User, Integer> {

	
	public Optional<User> findByUserId(Long userId);

}