package com.finalproject.FinalProject.entity.greenlight;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GreenLocation {
	private ArrayList<String> coordinates;

	public GreenLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<String> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "GreenLocation [coordinates=" + coordinates + "]";
	}
	
	
	

}
