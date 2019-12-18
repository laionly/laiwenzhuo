package com.xxx.tx.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xxx.tx.dao.BookDao;
import com.xxx.tx.exception.AccountException;
import com.xxx.tx.exception.BookStockException;

/**
 * 
 * <p>Title: BookDaoImpl</p>  
 * <p>Description: 书籍实现类</p>  
 * @author  wpf  
 * @date  2019年12月3日
 */
@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql="select price from book where isbn=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	@Override
	public boolean updateBookStock(String isbn) {
		//检查书的库存，是否足够
		String sql2="select stock from book where isbn=?";
		int stock = this.jdbcTemplate.queryForObject(sql2,Integer.class, isbn);
		if(stock==0){
			throw new BookStockException("库存不足");
		}
		String sql="update book set stock=stock-1 where isbn=?";
		int result = this.jdbcTemplate.update(sql, isbn);
		if(result>0){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean updateAccount(String name, int money) {
		//验证余额是否足够
		//检查书的库存，是否足够
		String sql2="select money from account where name=?";
		int balance = this.jdbcTemplate.queryForObject(sql2,Integer.class, name);
		if(balance < money){
			throw new AccountException("余额不足");
		}
		
		String sql="update account set money=money-? where name=?";
		int result = this.jdbcTemplate.update(sql, money,name);
		if(result>0){
			return true;
		}else{
			return false;
		}
		
	}

}
