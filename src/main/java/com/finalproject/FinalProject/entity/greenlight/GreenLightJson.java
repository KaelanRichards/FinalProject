package com.finalproject.FinalProject.entity.greenlight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finalproject.FinalProject.entity.geo.Location;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GreenLightJson {
	
	private Location location;

	public GreenLightJson() {
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
		return "GreenLightJson [location=" + location + "]";
	}
	
	

}
