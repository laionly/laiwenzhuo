package com.xxx.sh.dao;

public interface BookDao {
	public double findBookPriceByIsbn(String isbn);
	public void updateBookStock(String isbn);
	public void updateMoney(String name,double price);

}
