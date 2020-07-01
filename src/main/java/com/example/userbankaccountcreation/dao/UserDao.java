package com.example.userbankaccountcreation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userbankaccountcreation.model.User;

@Repository
public interface UserDao extends CrudRepository<User ,Integer> {

	User findUserIdBYPanNumber(String panNumber);

}
