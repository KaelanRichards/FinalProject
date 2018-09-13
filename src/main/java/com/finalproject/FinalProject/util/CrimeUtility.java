package com.finalproject.FinalProject.util;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.finalproject.FinalProject.entity.Crime;

public class CrimeUtility {
	
	public static ArrayList<Crime> crimesNearAddress(ArrayList<Crime> crimeList, double userLat, double userLong) {
		
		ArrayList<Crime> crimesInRange = new ArrayList<Crime>();
		for (Crime c : crimeList) {
			double distance = UtilityClass.distFrom(userLat, userLong, c.getLatitude(), c.getLongitude());
			if (distance < 0.26) {
				crimesInRange.add(c);
			}
		}

		return crimesInRange;

	}
	
	public static ArrayList<Crime> theftOffense(String year, double userLat, double userLong) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> stolenVehicle = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=24001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> larceny = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=23007&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> burglary = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=22001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		// initializing a list for theft crimes
		ArrayList<Crime> theftList = new ArrayList<Crime>();
		// adding stolen vehicles to our theft category list
		for (Crime c : stolenVehicle.getBody()) {
			theftList.add(c);
		}
		// adding larceny to our theft category list
		for (Crime c : larceny.getBody()) {
			theftList.add(c);
		}
		// adding burglary to our theft category list
		for (Crime c : burglary.getBody()) {
			theftList.add(c);
		}
		// test to see if we have the right data
		for (int i = 0; i < theftList.size(); i++) {
			System.out.println(theftList.get(i));
		}
		theftList = crimesNearAddress(theftList, userLat, userLong);
		return theftList;
	}
	public static ArrayList<Crime> sexOffense(String year, double userLat, double userLong) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> firstDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> secondDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11007&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		// initializing a list for theft crimes
		ArrayList<Crime> sexualAssaultList = new ArrayList<Crime>();
		// adding First degree sex offenses to SA list
		for (Crime c : firstDegree.getBody()) {
			sexualAssaultList.add(c);
		}
		// adding second degree sex offense to SA list
		for (Crime c : secondDegree.getBody()) {
			sexualAssaultList.add(c);
		}
		sexualAssaultList = crimesNearAddress(sexualAssaultList, userLat, userLong);
		return sexualAssaultList;
	}
	public static ArrayList<Crime> violentOffense(String year, double userLat, double userLong) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> aggraAssault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13002&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> assault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13001&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> robbery = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=12000&year=" + year, HttpMethod.GET, entity,
				Crime[].class);

		// initializing a list for theft crimes
		ArrayList<Crime> violentList = new ArrayList<Crime>();
		// adding First degree sex offenses to SA list
		for (Crime c : assault.getBody()) {
			violentList.add(c);
		}
		// adding second degree sex offense to SA list
		for (Crime c : robbery.getBody()) {
			violentList.add(c);
		}
		for (Crime c : aggraAssault.getBody()) {
			violentList.add(c);
		}
		
		violentList = crimesNearAddress(violentList, userLat, userLong);
		return violentList;
	}
}
