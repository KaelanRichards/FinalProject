package com.finalproject.FinalProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loginuser")
public class LoginUser {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) //auto increment
	//pojo
	
	private int id;
	private String username;
	private String password;
	
	
	
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LoginUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}



	public LoginUser(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	}

