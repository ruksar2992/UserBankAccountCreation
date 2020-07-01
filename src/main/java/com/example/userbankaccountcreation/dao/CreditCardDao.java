package com.example.userbankaccountcreation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userbankaccountcreation.model.CreditCard;

@Repository
public interface CreditCardDao extends CrudRepository<CreditCard, Integer> {

	CreditCard findAllByUserId(int userId);

}
