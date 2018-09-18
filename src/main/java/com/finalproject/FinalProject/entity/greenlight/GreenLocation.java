package com.finalproject.FinalProject.entity.greenlight;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GreenLocation {
	private ArrayList<Coordinates> coordinates;

	public GreenLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(ArrayList<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "GreenLocation [coordinates=" + coordinates + "]";
	}
	
	
	

}
