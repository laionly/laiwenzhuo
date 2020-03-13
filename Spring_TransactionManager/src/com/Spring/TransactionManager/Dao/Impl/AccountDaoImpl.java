package com.Spring.TransactionManager.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Spring.TransactionManager.Dao.IAccountDao;
import com.Spring.TransactionManager.entity.Account;
@Repository
public class AccountDaoImpl implements IAccountDao{
	@Autowired
	public JdbcTemplate Jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		Jdbctemplate = jdbctemplate;
	}
	//根据AccountId查询账户信息
	@Override
	public Account finAccountById(Integer id) {
		String sql="select * from account where id=?";
		RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);
		Account account=Jdbctemplate.queryForObject(sql, rowMapper, id);
		return account;
	}
	//更新账户信息
	@Override
	public int updateAccount(Account account) {
		String sql="update account set money=? where id=?";
		Object[] objects=new Object[] {account.getMoney(),account.getId()};
		int result=Jdbctemplate.update(sql,objects);
		return result;
	}

}
