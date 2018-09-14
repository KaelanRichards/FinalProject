package com.finalproject.FinalProject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String phone;
	private String confirmpassword;
	// mappedBy refers to the user object we created in our favorites class (not the table)
	@OneToMany (mappedBy = "user")
	private List<Favorite> favorites = new ArrayList<>();
	
	
	



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(Long userid, String username, String password, String firstname, String lastname, String phone,
			String confirmpassword, List<Favorite> favorites) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.confirmpassword = confirmpassword;
		this.favorites = favorites;
	}
	public User( String username, String password, String firstname, String lastname, String phone,
			String confirmpassword,List<Favorite> favorites) {
		
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.confirmpassword = confirmpassword;
		this.favorites=favorites;
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
	
	public Long getUserid() {
		return userid;
	}



	public void setUserid(Long userid) {
		this.userid = userid;
	}



	public List<Favorite> getFavorites() {
		return favorites;
	}



	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}


	@Override
	public String toString() {
		return "LoginUser [userid=" + userid + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", phone=" + phone + ", confirmpassword=" + confirmpassword + "]";
	}



	
	
	}

