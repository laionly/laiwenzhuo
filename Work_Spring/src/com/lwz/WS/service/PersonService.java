package com.lwz.WS.service;

import com.lwz.WS.entity.Person;

public interface PersonService {
	public boolean login(String username,String password);
	public void addPerson(Person person);

}
