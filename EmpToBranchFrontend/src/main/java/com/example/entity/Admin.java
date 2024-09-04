package com.example.entity;


public class Admin {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [password=" + password + "]";
	}
	
	
}
