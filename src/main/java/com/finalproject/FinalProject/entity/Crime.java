package com.finalproject.FinalProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Crime {
	
	//these are the data we want to show out from all crime incidents (2016-Present)
	//https://data.detroitmi.gov/resource/9i6z-cm98.json
	
	@JsonProperty("arrest_charge")
	private String arrestCharge;
	@JsonProperty("charge_description")
	private String chargeDesc;
	@JsonProperty("crime_id")
	private String crimeId;
	// data types we are using from the API 
	@JsonProperty("incident_timestamp")
	private String date;
	@JsonProperty("neighborhood")
	private String neighborhood;
	@JsonProperty("scout_car_area")
	private String scoutCar;
	@JsonProperty("hour_of_day")
	private int hourOfDay;
	@JsonProperty("offense_category")
	private String offenseCategory;
	@JsonProperty("precinct")
	private int precinct;
	@JsonProperty ("year")
	private int year;
	@JsonProperty ("longitude")
	private double longitude;
	@JsonProperty("latitude")
	private double latitude;
	
	
	public Crime() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getArrestCharge() {
		return arrestCharge;
	}


	public void setArrestCharge(String arrestCharge) {
		this.arrestCharge = arrestCharge;
	}


	public String getChargeDesc() {
		return chargeDesc;
	}


	public void setChargeDesc(String chargeDesc) {
		this.chargeDesc = chargeDesc;
	}


	public String getCrimeId() {
		return crimeId;
	}


	public void setCrimeId(String crimeId) {
		this.crimeId = crimeId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getNeighborhood() {
		return neighborhood;
	}


	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}


	public String getScoutCar() {
		return scoutCar;
	}


	public void setScoutCar(String scoutCar) {
		this.scoutCar = scoutCar;
	}


	public int getHourOfDay() {
		return hourOfDay;
	}


	public void setHourOfDay(int hourOfDay) {
		this.hourOfDay = hourOfDay;
	}


	public String getOffenseCategory() {
		return offenseCategory;
	}


	public void setOffenseCategory(String offenseCategory) {
		this.offenseCategory = offenseCategory;
	}


	public int getPrecinct() {
		return precinct;
	}


	public void setPrecinct(int precinct) {
		this.precinct = precinct;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	@Override
	public String toString() {
		return "Crime [arrestCharge=" + arrestCharge + ", chargeDesc=" + chargeDesc + ", crimeId=" + crimeId + ", date="
				+ date + ", neighborhood=" + neighborhood + ", scoutCar=" + scoutCar + ", hourOfDay=" + hourOfDay
				+ ", offenseCategory=" + offenseCategory + ", precinct=" + precinct + ", year=" + year + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}
	
	
	
	
	
	

}
