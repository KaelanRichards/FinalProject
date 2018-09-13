package com.finalproject.FinalProject.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeoTest {
	
	//beginning JSON 
	@JsonProperty("results")
	private ArrayList <ResultForGeo> results;

	public GeoTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ResultForGeo> getResults() {
		return results;
	}

	public void setResults(ArrayList<ResultForGeo> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "GeoTest [results=" + results + "]";
	}
	
	
	

}
