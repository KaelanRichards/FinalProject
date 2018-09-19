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
	
	public static ArrayList<Crime> localCrimeOffense(int chargeNumber, String year, double userLat, double userLong) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Crime[]> crime = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=" + chargeNumber + "&year=" + year,
				HttpMethod.GET, entity, Crime[].class);
		// initializing a list for theft crimes
		ArrayList<Crime> localCrimeList = new ArrayList<Crime>();
		// adding stolen vehicles to our theft category list
		for (Crime c : crime.getBody()) {
			localCrimeList.add(c);
		}
	
		localCrimeList = crimesNearAddress(localCrimeList, userLat, userLong);
		return localCrimeList;
	}

	public static int crimeListFromAPI(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> stolenVehicle = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=24001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> larceny = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=23007", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> burglary = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=22001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> firstDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> secondDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11007", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> aggraAssault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13002", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> assault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> robbery = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=12000", HttpMethod.GET, entity,
				Crime[].class);
	

		int sizeAllCrime = assault.getBody().length 
				+ robbery.getBody().length 
				+ aggraAssault.getBody().length
				+ firstDegree.getBody().length
				+ secondDegree.getBody().length
				+ burglary.getBody().length
				+ larceny.getBody().length
				+ stolenVehicle.getBody().length;
		
		return sizeAllCrime;
		
	}
	
	public static double averageTotalCrimeList() {

		double totalCrimeNumber = crimeListFromAPI();
		double findDetroitAverage = totalCrimeNumber;
		double quarterMileRadiusAverage = findDetroitAverage /  715;
		System.out.println("Average1: " + findDetroitAverage + " Average2: " + quarterMileRadiusAverage);
		return quarterMileRadiusAverage;
	}
	// this is the avg in 0.25mi^2
	//real number should be 7.3
	public static int crimeLocalList(double userLat, double userLong){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ArrayList<Crime> localList = new ArrayList<>();

		ResponseEntity<Crime[]> stolenVehicle = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=24001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> larceny = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=23007", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> burglary = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=22001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> firstDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> secondDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11007", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> aggraAssault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13002", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> assault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> robbery = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=12000", HttpMethod.GET, entity,
				Crime[].class);
		for (Crime c : assault.getBody()) {
			localList.add(c);
		}
		// adding second degree sex offense to SA list
		for (Crime c : robbery.getBody()) {
			localList.add(c);
		}
		for (Crime c : aggraAssault.getBody()) {
			localList.add(c);
		}
		for (Crime c : firstDegree.getBody()) {
			localList.add(c);
		}
		// adding second degree sex offense to SA list
		for (Crime c : secondDegree.getBody()) {
			localList.add(c);
		}
		for (Crime c : stolenVehicle.getBody()) {
			localList.add(c);
		}
		// adding larceny to our theft category list
		for (Crime c : larceny.getBody()) {
			localList.add(c);
		}
		// adding burglary to our theft category list
		for (Crime c : burglary.getBody()) {
			localList.add(c);
		}
		localList = crimesNearAddress(localList, userLat, userLong);
		return localList.size();
	}

	public static double averageTotalLocalCrimeList(double userLat, double userLong) {

		double totalLocalCrimeNumber = crimeLocalList(userLat, userLong);
		double average = totalLocalCrimeNumber / 3;
		return average;
	}
	
	public static int calculateAvgDecrease(double avgTotal, double avgLocal) {
		double decrease = avgTotal - avgLocal;
		double decreaseTotal = decrease / avgTotal;
		double decreasePercentage = decreaseTotal * 100;

		return (int) decreasePercentage;

	}
	
	public static int calculateAvgIncrease(double avgTotal, int avgLocal) {

		double increase = avgLocal - avgTotal;
		double increaseTotal = increase / avgTotal;
		double increasePercentage = increaseTotal * 100;
		return (int) increasePercentage;
	}
	
	public static String calculateSafetyPercentage(int allTotal, int localTotal) {
		
		 if (allTotal >= localTotal) {
			 return "Average";
		 }
		 
		 else if(allTotal >= localTotal ) {
			int decrease = calculateAvgDecrease(allTotal, localTotal);
			if (decrease >= 50) {
				
				return "very safe";
			} else if (decrease >= 15) {
				return "moderately safe";
			} else if (decrease >= 1) {
				
				return "average";
			}
		}
		// neighborhood gets less points for greater increase in crime
		else if (allTotal <= localTotal) {
			int increase = calculateAvgIncrease(allTotal, localTotal);
			if (increase >= 50) {
				
				return "very dangerous";
			} else if (increase >= 15) {
				
				return "dangerous";
			} else if (increase >= 1) {
				
				
				
				return "average";
			}
		}
		 System.out.println("all total: " + allTotal + "localTotal: " + localTotal);
		return "HELLO WHIRLED";
	}
	


}
