package com.finalproject.FinalProject.entity.geo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeoJson {
	
	private String status;
	private ArrayList<GeoResults> geoResults;

	public ArrayList<GeoResults> getResults() {
		return geoResults;
	}

	public void setResults(ArrayList<GeoResults> results) {
		this.geoResults = results;
	}

	public GeoJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GeoJson [status=" + status + "georesults " + geoResults;
	}
	
	

}
