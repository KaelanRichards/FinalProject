package com.finalproject.FinalProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LocationGeo {
	
	private Double lat;
	private Double lng;
	public LocationGeo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "LocationGeo [lat=" + lat + ", lng=" + lng + "]";
	}
	
	

}
