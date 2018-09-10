package com.finalproject.FinalProject.entity;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CallResponse {
	@JsonProperty("neighborhood")
	private String neighborhood;
	@JsonProperty("totalresponsetime")
	private Double totalresponsetime;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonProperty("latitude")
	private Double latitude;
	public CallResponse() {
		
	}
	public CallResponse(String neighborhood, Double totalresponsetime, Double longitude, Double latitude) {
		super();
		this.neighborhood = neighborhood;
		this.totalresponsetime = totalresponsetime;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public Double getTotalresponsetime() {
		return totalresponsetime;
	}
	public void setTotalresponsetime(Double totalresponsetime) {
		this.totalresponsetime = totalresponsetime;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	@Override
	public String toString() {
		return "CallResponse [neighborhood=" + neighborhood + ", totalresponsetime=" + totalresponsetime
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
	
	

}
