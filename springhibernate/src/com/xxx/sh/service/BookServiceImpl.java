package com.xxx.sh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.sh.dao.BookDao;

@Service("bservice")
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bd;

	@Override
	@Transactional
	public void purchase(String name, String isbn) {
		double price=bd.findBookPriceByIsbn(isbn);
		bd.updateBookStock(isbn);
		bd.updateMoney(name, price);
		
	}
	
	
	

}
