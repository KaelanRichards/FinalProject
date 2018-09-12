package com.finalproject.FinalProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loginuser")
public class LoginUser {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String phone;
	private String confirmpassword;
	
	
	
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LoginUser(Integer id, String username, String password, String firstname, String lastname, String phone,
			String confirmpassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.confirmpassword = confirmpassword;
	}
	public LoginUser( String username, String password, String firstname, String lastname, String phone,
			String confirmpassword) {
		
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.confirmpassword = confirmpassword;
	}




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
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



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getConfirmpassword() {
		return confirmpassword;
	}



	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}



	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", phone=" + phone + ", confirmpassword=" + confirmpassword + "]";
	}



	
	
	}

