package com.xxx.tx.dao;

public interface BookDao {
	//根据书号查询书的单价
	public int findBookPriceByIsbn(String isbn);
	//更新书的库存
	public boolean updateBookStock(String isbn);
	//更新用户余额
	public boolean updateAccount(String name,int money);

}
