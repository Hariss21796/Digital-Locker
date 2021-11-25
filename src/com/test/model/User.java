package com.test.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String email;
	private String password;
	private String cnfpassword;

	public User(int id, String userName, String email, String password, String cnfpassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.cnfpassword = cnfpassword;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnfpassword() {
		return cnfpassword;
	}

	public void setCnfpassword(String cnfpassword) {
		this.cnfpassword = cnfpassword;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + userName + ", email=" + email + ", password=" + password
				+ ", cnfpassword=" + cnfpassword + "]";
	}

}
