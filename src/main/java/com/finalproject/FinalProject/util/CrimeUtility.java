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
	
	public static ArrayList<Crime> createMasterList(ArrayList<Crime> theftList, ArrayList<Crime> violentList, ArrayList<Crime> sexList){
		
		ArrayList<Crime> masterList = new ArrayList<Crime>();
		masterList.addAll(theftList);
		masterList.addAll(violentList);
		masterList.addAll(sexList);
		
		return masterList;
	}
	
	public static int[] getCrimeTotals(String year, double userLat, double userLong) {
		
		ArrayList<Crime> theftList = CrimeUtility.theftOffense(year, userLat, userLong);
		ArrayList<Crime> violentList = CrimeUtility.violentOffense(year, userLat, userLong);
		ArrayList<Crime> sexList = CrimeUtility.sexOffense(year, userLat, userLong);
		ArrayList<Crime> masterList = CrimeUtility.createMasterList(theftList, violentList, sexList);
		int[] totals = {violentList.size(),sexList.size(), theftList.size(),masterList.size()};
		
		return totals;
	}
	
	// Calculate the crime data decrease from 2016 to 2018
	public static int calculateDecrease(int crime2016, int crime2018) {
		double decrease = crime2016 - crime2018;
		double decreaseTotal = decrease / crime2016;
		double decreasePercentage = decreaseTotal * 100;

		return (int) decreasePercentage;

	}

	// Calculate the crime data increase from 2016 to 2018
	public static int calculateIncrease(int crime2016, int crime2018) {

		double increase = crime2018 - crime2016;
		double increaseTotal = increase / crime2016;
		double increasePercentage = increaseTotal * 100;
		return (int) increasePercentage;
	}
	// we pass in a score weight (all weights should sum to 100) and to ints for crime comparison
	// the return should be one score (of type int) for a particular crime category
	public static double calculateCrimeScore(double scoreWeight, int crime2016, int crime2018) {
		double score = 25;
//		System.out.println("Score: " + score);
//		System.out.println("scoreweight: " + scoreWeight);
//		
//		System.out.println("**" + crime2016);
//		System.out.println("****" + crime2018);
		// neighborhood gets full points if crime is zero
		if (crime2018 == 0) {
			score = scoreWeight;
			System.out.println("1");
			return score;
			
		} 
		// neighborhood gets half points for no increase or decrease in crime
		else if (crime2016 == crime2018) {
			score = scoreWeight / 2;
			System.out.println("2");
			return score;
		} 
		// neighborhood gets more points for greater decrease in crime
		else if (crime2016 > crime2018) {
			int decrease = calculateDecrease(crime2016, crime2018);
			if (decrease >= 50) {
				score += scoreWeight;
				System.out.println("3");
				return score;
			} else if (decrease >= 25) {
				score = scoreWeight * .75;
				System.out.println("4");
				return score;
			} else if (decrease >= 1) {
				score = scoreWeight * .6;
				System.out.println("5");
				System.out.println(score);
				return score;
			}
		}
		// neighborhood gets less points for greater increase in crime
		else if (crime2016 < crime2018) {
			int increase = calculateIncrease(crime2016, crime2018);
			if (increase >= 50) {
				System.out.println("6");
				score = 0;
				return score;
			} else if (increase >= 25) {
				score = scoreWeight * .25;
				System.out.println("7");
				System.out.println(score);
				return score;
			} else if (increase >= 1) {
				score = scoreWeight * .4;
				System.out.println("8");
				System.out.println(score);
				
				return score;
			}
		}

		return score;
	}
	
	public static String sumScoreCategories(int[] crime2016, int[] crime2018) {
		
		double vScore = calculateCrimeScore(20, crime2016[0], crime2018[0]);
		
		double sScore = calculateCrimeScore(20, crime2016[1], crime2018[1]);
		double tScore = calculateCrimeScore(20, crime2016[2], crime2018[2]);
		double overallScore = calculateCrimeScore(40, crime2016[3], crime2018[3]);
		double sumScores = vScore + sScore + tScore + overallScore;
		String grade = "";
		
		if (sumScores > 89) {
			grade = "A";
		} else if (sumScores > 79) {
			grade = "B";
		} else if (sumScores > 69) {
			grade = "C";
		} else if (sumScores > 59) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		
		return grade;
	}


}
