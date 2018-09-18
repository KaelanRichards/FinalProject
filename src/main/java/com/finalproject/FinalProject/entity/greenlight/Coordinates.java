package com.finalproject.FinalProject.entity.greenlight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {
	
	@JsonProperty("0")
	private double lng;
	@JsonProperty("1")
	private double lat;
	public Coordinates() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Coordinates [lng=" + lng + ", lat=" + lat + "]";
	}
	
	

}
