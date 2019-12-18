package com.lwz.WS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwz.WS.dao.PersonDao;
import com.lwz.WS.entity.Person;

@Service("pservice")
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao pd;

	@Transactional
	public boolean login(String username, String password) {
		boolean loginok = pd.PersonLogin(username, password);
		return loginok;

	}

	@Override
	@Transactional
	public void addPerson(Person person) {
		pd.addPerson(person);
		
	}

}
