package com.finalproject.FinalProject.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	
	// @JsonProperty("results")
	private ArrayList<Crime> results ;

	public Results() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Crime> getResults() {
		return results;
	}

	public void setResults(ArrayList<Crime> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Results [results=" + results + "]";
	}
	
	
}
