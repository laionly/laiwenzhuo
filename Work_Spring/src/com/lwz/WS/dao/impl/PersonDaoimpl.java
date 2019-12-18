package com.lwz.WS.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.lwz.WS.dao.PersonDao;
import com.lwz.WS.entity.Person;

//@Component
@Repository
public class PersonDaoimpl implements PersonDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPerson(Person person) {
//		 String sql="insert into person(username,password,email,address) values(?,?,?,?)";
//		 Object[] obj=new Object[]{person.getUsername(),person.getPassword(),person.getEmail(),person.getAddress()};
//		 this.jdbcTemplate.update(sql, obj);

		getSession().save(person);

	}

	@Override
	public boolean PersonLogin(String username, String password) {
		try {
			//hql不能有插入语句，只能查找，删除
			String hql = "from Person where username=? and password=?";
			System.out.println(username);
			Query<?> query = getSession().createQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, password);
			query.uniqueResult();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
