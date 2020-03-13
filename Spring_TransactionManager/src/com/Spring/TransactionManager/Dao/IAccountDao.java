package com.Spring.TransactionManager.Dao;

import com.Spring.TransactionManager.entity.Account;

public interface IAccountDao {
	Account finAccountById(Integer id);
	int updateAccount(Account account);

}
