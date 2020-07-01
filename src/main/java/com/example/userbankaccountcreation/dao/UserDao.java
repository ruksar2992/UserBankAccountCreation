package com.example.userbankaccountcreation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userbankaccountcreation.model.User;

@Repository

public interface UserDao extends CrudRepository<User ,Integer> {

	User findUserIdByPanNumber(String panNumber);

	public User findByCustomerIdAndPassword(int customerId, String password);

	User findAllByUserId(int userId);

}
