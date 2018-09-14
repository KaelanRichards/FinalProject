package com.finalproject.FinalProject.util;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.finalproject.FinalProject.entity.Crime;

public class AverageCrimeUtility {

	public static int crimeListByYear(String year){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		
		ArrayList<Crime> allCrimeList = new ArrayList<Crime>();

		ResponseEntity<Crime[]> stolenVehicle = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=24001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> larceny = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=23007&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> burglary = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=22001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		
		// adding stolen vehicles to our theft category list
		for (Crime c : stolenVehicle.getBody()) {
			allCrimeList.add(c);
		}
		// adding larceny to our theft category list
		for (Crime c : larceny.getBody()) {
			allCrimeList.add(c);
		}
		// adding burglary to our theft category list
		for (Crime c : burglary.getBody()) {
			allCrimeList.add(c);
		}
		ResponseEntity<Crime[]> firstDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> secondDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11007&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		
		// adding First degree sex offenses to SA list
		for (Crime c : firstDegree.getBody()) {
			allCrimeList.add(c);
		}
		// adding second degree sex offense to SA list
		for (Crime c : secondDegree.getBody()) {
			allCrimeList.add(c);
		}
		ResponseEntity<Crime[]> aggraAssault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13002&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> assault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> robbery = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=12000&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		
		// adding First degree sex offenses to SA list
		for (Crime c : assault.getBody()) {
			allCrimeList.add(c);
		}
		// adding second degree sex offense to SA list
		for (Crime c : robbery.getBody()) {
			allCrimeList.add(c);
		}
		for (Crime c : aggraAssault.getBody()) {
			allCrimeList.add(c);
		}
		return allCrimeList.size();
		
	}
	
	public static int allCrimeList() {
		int totalCrimeNumber;
		totalCrimeNumber = crimeListByYear("2016") + crimeListByYear("2017") + crimeListByYear("2018");
		return totalCrimeNumber;
	}
	
	public static int averageTotalCrimeList() {

		int totalCrimeNumber = allCrimeList();
		int average = totalCrimeNumber / 3;
		return average;
	}
	public static int allLocalCrimeList(double userLat, double userLong) {
		int var16 = CrimeUtility.getCrimeTotals("2016", userLat, userLong)[3];
		int var17 = CrimeUtility.getCrimeTotals("2017", userLat, userLong)[3];
		int var18 = CrimeUtility.getCrimeTotals("2018", userLat, userLong)[3];
		int total = var16 + var17 + var18;
		return total;
		
	}
	public static int averageTotalLocalCrimeList(double userLat, double userLong) {

		int totalLocalCrimeNumber = allLocalCrimeList(userLat, userLong);
		int average = totalLocalCrimeNumber / 3;
		return average;
	}
}
