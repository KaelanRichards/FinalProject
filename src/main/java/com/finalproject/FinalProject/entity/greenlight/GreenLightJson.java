package com.finalproject.FinalProject.entity.greenlight;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GreenLightJson {
	@JsonProperty("business_name")
	private String businessName;
	private String address;
	private GreenLocation location;

	
	
	public GreenLightJson(String businessName, String address, GreenLocation location) {
		this.businessName = businessName;
		this.address = address;
		this.location = location;
	}

	public GreenLightJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GreenLocation getLocation() {
		return location;
	}

	public void setLocation(GreenLocation location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "GreenLightJson [businessName=" + businessName + ", address=" + address + ", location=" + location + "]";
	}

	
	
	

}
