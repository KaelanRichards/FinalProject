package com.finalproject.FinalProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Crime {
	
	//these are the data we want to show out from all crime incidents (2016-Present)
	//https://data.detroitmi.gov/resource/9i6z-cm98.json
	
	@JsonProperty("address")
	private String address;
	@JsonProperty("arrest_charge")
	private String arrestCharge;
	@JsonProperty("block_id")
	private String blockId;
	@JsonProperty("charge_description")
	private String chargeDesc;
	@JsonProperty("council_district")
	private String councilDis;
	@JsonProperty("crime_id")
	private String crimeId;
	@JsonProperty("incident_timestamp")
	private String date;
	@JsonProperty("neighborhood")
	private String neighborhood;
	@JsonProperty("scout_car_area")
	private String scoutCar;
	
	public Crime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArrestCharge() {
		return arrestCharge;
	}
	public void setArrestCharge(String arrestCharge) {
		this.arrestCharge = arrestCharge;
	}
	public String getBlockId() {
		return blockId;
	}
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}
	public String getChargeDesc() {
		return chargeDesc;
	}
	public void setChargeDesc(String chargeDesc) {
		this.chargeDesc = chargeDesc;
	}
	public String getCouncilDis() {
		return councilDis;
	}
	public void setCouncilDis(String councilDis) {
		this.councilDis = councilDis;
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
	@Override
	public String toString() {
		return "Crime [address=" + address + ", arrestCharge=" + arrestCharge + ", blockId=" + blockId + ", chargeDesc="
				+ chargeDesc + ", councilDis=" + councilDis + ", crimeId=" + crimeId + ", date=" + date
				+ ", neighborhood=" + neighborhood + ", scoutCar=" + scoutCar + "]";
	}
	
	
	
	

}
