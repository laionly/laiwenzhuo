package com.xxx.tx.service;

public interface AccountService {
	//转账
	public void transfer(String outName,String inName,double money);
	//购买书籍的方法
	public void purchase(String name,String isbn);
}
