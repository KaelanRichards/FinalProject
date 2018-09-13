package com.finalproject.FinalProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AddressCom {
	
	@JsonProperty("street_number")
	private String streetNumber;
	
	@JsonProperty("route")
	private String streetName;
	
	@JsonProperty("locality")
	private String city;
	
	
	@JsonProperty("administrative_area_level_1")
	private String state;


	public AddressCom() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "AddressCom [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", state="
				+ state + "]";
	} 
	
	
	
	
	

}
