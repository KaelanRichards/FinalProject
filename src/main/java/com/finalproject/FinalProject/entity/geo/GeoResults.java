package com.finalproject.FinalProject.entity.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoResults {
	private String formatted_address;
	private String place_id;

	private Geometry geometry;

	public GeoResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	@Override
	public String toString() {
		return "GeoResults [formatted_address=" + formatted_address + ", place_id=" + place_id + "geometry =" + geometry +"]";
	}

}
