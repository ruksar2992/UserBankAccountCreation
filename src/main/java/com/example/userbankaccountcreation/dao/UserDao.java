package com.example.userbankaccountcreation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userbankaccountcreation.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	/**
	 * This method is used to authenticate User
	 * 
	 * @param customerId
	 * @param password
	 * @return
	 */
	public User findByCustomerIdAndPassword(int customerId, String password);

}
