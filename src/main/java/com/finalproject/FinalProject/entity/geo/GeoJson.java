package com.finalproject.FinalProject.entity.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeoJson {
	
	private String status;

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
		return "GeoJson [status=" + status + "]";
	}
	
	

}
