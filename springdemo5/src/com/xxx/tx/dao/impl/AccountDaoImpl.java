package com.xxx.tx.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xxx.tx.dao.AccountDao;

@Repository("dao")
public class AccountDaoImpl implements AccountDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean transferOut(String outName, double money) {
		//根据用户名查询金额，是否大于0
		String sqla="select money from account where name=?";
		String sql="update account set money=money-? where name=?";
		int result = this.jdbcTemplate.update(sql, money,outName);
		return result>0;
	}

	@Override
	public boolean transferIn(String inName, double money) {
		String sql="update account set money=money+? where name=?";
		int result = this.jdbcTemplate.update(sql, money,inName);
		return result>0;
	}

}
