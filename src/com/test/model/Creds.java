package com.test.model;

import java.io.Serializable;

public class Creds implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String siteName;
	private String userName;
	private String password;

	public Creds(String id, String siteName, String userName, String password) {
		super();
		this.id = id;
		this.siteName = siteName;
		this.userName = userName;
		this.password = password;
	}

	public Creds() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Creds [id=" + id + ", siteName=" + siteName + ", userName=" + userName + ", password=" + password + "]";
	}

}
