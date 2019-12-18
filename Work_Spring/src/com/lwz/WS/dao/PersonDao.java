package com.lwz.WS.dao;

import com.lwz.WS.entity.Person;

public interface PersonDao {
	public void addPerson(Person person);
	public boolean PersonLogin(String uesrname,String password);

}
