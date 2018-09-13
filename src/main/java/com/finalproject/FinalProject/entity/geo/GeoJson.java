package com.finalproject.FinalProject.entity.geo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeoJson {
	
	private String status;
	private ArrayList<Results> results;

	public ArrayList<Results> getResults() {
		return results;
	}

	public void setResults(ArrayList<Results> results) {
		this.results = results;
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
		return "GeoJson [status=" + status + "results " + results;
	}
	
	

}
