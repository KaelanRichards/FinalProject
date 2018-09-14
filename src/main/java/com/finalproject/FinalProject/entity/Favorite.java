package com.finalproject.FinalProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")

	
public class Favorite {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long favid;
	private String address;
	private String category;
	@ManyToOne @JoinColumn (name="userid")
	private User user;
	public Favorite() {
		super();
	
	}
	public Favorite(Long favid, String address, String category, User user) {
		super();
		this.favid = favid;
		this.address = address;
		this.category = category;
		this.user = user;
	}
	public Favorite(String address, String category, User user) {
		super();
		this.address = address;
		this.category = category;
		this.user = user;
	}
	public Long getFavid() {
		return favid;
	}
	public void setFavid(Long favid) {
		this.favid = favid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Favorite [favid=" + favid + ", address=" + address + ", category=" + category + ", user=" + user + "]";
	}
	
	
}
