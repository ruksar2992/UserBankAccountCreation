package com.example.userbankaccountcreation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userbankaccountcreation.model.Account;


@Repository
public interface AccountDao extends CrudRepository<Account ,Integer> {

}
