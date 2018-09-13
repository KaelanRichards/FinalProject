package com.finalproject.FinalProject.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//results 
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultForGeo {
	
	
	@JsonProperty("address_components")
	private ArrayList<AddressCom> addresscom;
	
	@JsonProperty("geometry")
	private Geometry geometry;

	public ResultForGeo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<AddressCom> getAddresscom() {
		return addresscom;
	}

	public void setAddresscom(ArrayList<AddressCom> addresscom) {
		this.addresscom = addresscom;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "ResultForGeo [addresscom=" + addresscom + ", geometry=" + geometry + "]";
	}

	
	
	

}
