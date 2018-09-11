package com.finalproject.FinalProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@Column (name ="contact_info")
	private String contactInfo;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String contactInfo) {
		super();
		this.id = id;
		this.contactInfo = contactInfo;
	}
	
	public User( String contactInfo) {
		
		this.contactInfo = contactInfo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", contactInfo=" + contactInfo + "]";
	}

	
}
