package com.example.userbankaccountcreation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userbankaccountcreation.model.AccountSummary;

@Repository
public interface AccountDao extends CrudRepository<AccountSummary, Integer> {

	AccountSummary findAllByUserId(int userId);

}
