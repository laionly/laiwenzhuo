package com.skishop.entity;
// Generated 2019-11-19 23:45:26 by Hibernate Tools 5.2.3.Final

/**
 * Admin generated by hbm2java
 */
public class Admin {

	private String email;
	private String surname;
	private String name;
	private String password;

	public Admin() {
	}

	public Admin(String email, String surname) {
		this.email = email;
		this.surname = surname;
	}

	public Admin(String email, String surname, String name, String password) {
		this.email = email;
		this.surname = surname;
		this.name = name;
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
