package com.finalproject.FinalProject.entity.greenlight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GreenLightJson {
	
	private GreenLocation location;

	public GreenLightJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GreenLocation getLocation() {
		return location;
	}

	public void setLocation(GreenLocation location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "GreenLightJson [location=" + location + "]";
	}
	
	

}
