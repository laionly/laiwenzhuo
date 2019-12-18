package com.xxx.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.tx.dao.AccountDao;
import com.xxx.tx.dao.BookDao;
import com.xxx.tx.service.AccountService;
@Service("service")
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao ad;//注入Dao类型对象
	@Autowired
	private BookDao bd;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRES_NEW)
	public void transfer(String outName, String inName, double money) {
		//转出
		ad.transferOut(outName, money);
		//int d=5/0;
		//转入
		ad.transferIn(inName, money);
		
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void purchase(String name, String isbn) {
		//1.查询书的单价
		int price = bd.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		boolean stock = bd.updateBookStock(isbn);
		//3.更新用户余额
		boolean account = bd.updateAccount(name, price);
		
		
	}

}
