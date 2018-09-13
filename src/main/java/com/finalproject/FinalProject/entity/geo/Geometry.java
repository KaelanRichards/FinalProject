package com.finalproject.FinalProject.entity.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

	private Location location;

	public Geometry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Geometry [location=" + location + "]";
	}
	
	

}
