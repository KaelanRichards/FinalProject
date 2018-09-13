package com.finalproject.FinalProject.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Geometry {

	@JsonProperty("location")
	private ArrayList <LocationGeo> location;

	public Geometry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<LocationGeo> getLocation() {
		return location;
	}

	public void setLocation(ArrayList<LocationGeo> location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Geometry [location=" + location + "]";
	}
	
	
	
}
