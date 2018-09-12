package com.finalproject.FinalProject.controller;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.FinalProject.entity.Crime;
import com.finalproject.FinalProject.util.UtilityClass;

@Controller
public class CrimeController {

	// The mapping to our crimetable JSP

//	@RequestMapping("/crimetable")
//	public ModelAndView crimeTable() {
//		ModelAndView mv = new ModelAndView("crimetable");
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
//		
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Crime[]> response = restTemplate.exchange(
//				"https://data.detroitmi.gov/resource/9i6z-cm98.json",
//				HttpMethod.GET, entity, Crime[].class);
//		
//		System.out.println(listOfTheftOffenses());
//		
//		mv.addObject("test", response.getBody());
//		
//		return mv;
//	}

//	@RequestMapping("/crimetable")
//	public ModelAndView crimeTable() {
//		ModelAndView mv = new ModelAndView("crimetable");
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Crime[]> response = restTemplate.exchange("https://data.detroitmi.gov/resource/9i6z-cm98.json",
//				HttpMethod.GET, entity, Crime[].class);
//		// Test to see if Crime list work
////		for(int i = 0; i < listOfViolentCrimes().size(); i++) {
////			System.out.println(listOfViolentCrimes().get(i));
////		}
//		System.out.println(listOfTheftOffenses());
//
//		mv.addObject("test", response.getBody());
//		// System.out.println(Arrays.toString(response.getBody()));
//
//		return mv;
//	}

	// Pulls Robbery, Assault, Homicide from dataset and insert into list
//	public ArrayList<Crime> listOfViolentCrimes() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Crime[]> response = restTemplate.exchange("https://data.detroitmi.gov/resource/9i6z-cm98.json",
//				HttpMethod.GET, entity, Crime[].class);
//
//		ArrayList<Crime> robberyList = new ArrayList<Crime>();
//		for (Crime c : response.getBody()) {
//
//			if (c.getOffenseCategory().equals("ROBBERY")) {
//				robberyList.add(c);
//			}
//		}
//
//
//			if (c.getOffenseCategory().equals("ROBBERY") || c.getOffenseCategory().equals("ASSAULT")
//					|| c.getOffenseCategory().equals("AGGRAVATED ASSAULT"))  {
//				robberyList.add(c);
//			}
//		
//		
//		 for(int i = 0; i < robberyList.size(); i++) {
//		 System.out.println(robberyList.get(i)); }
//		 
//
//		return robberyList;
//
//	}

	// pull Sex offenses and sexual assualt from api and add to list
	public ArrayList<Crime> listOfSexualOffenses() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Crime[]> response = restTemplate.exchange("https://data.detroitmi.gov/resource/9i6z-cm98.json",
				HttpMethod.GET, entity, Crime[].class);

		ArrayList<Crime> sOffenseList = new ArrayList<Crime>();
		for (Crime c : response.getBody()) {
			if (c.getOffenseCategory().contains("SEX")) {
				sOffenseList.add(c);
			}
			for (int i = 0; i < sOffenseList.size(); i++) {
				System.out.println(sOffenseList.get(i));
			}
		}
		return sOffenseList;
	}

	// Burglary, Larceny, Stolen Vehicles List
	public ArrayList<Crime> listOfTheftOffenses() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Crime[]> response = restTemplate.exchange("https://data.detroitmi.gov/resource/9i6z-cm98.json",
				HttpMethod.GET, entity, Crime[].class);

		ArrayList<Crime> theftList = new ArrayList<Crime>();
		for (Crime c : response.getBody()) {
			if (c.getOffenseCategory().contains("LARCENY") || c.getOffenseCategory().contains("BURGLARY")
					|| c.getOffenseCategory().equalsIgnoreCase("STOLEN VEHICLE")) {
				theftList.add(c);
			}
//			for(int i = 0; i < sOffenseList.size(); i++) {
//			System.out.println(sOffenseList.get(i));
//		}
		}
		return theftList;
	}

	@RequestMapping("/crimetable")
	public ModelAndView violentCrime() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
//
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		ResponseEntity<Crime[]> aggraAssault = restTemplate.exchange(
//				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13002", HttpMethod.GET, entity,
//				Crime[].class);
//
//		ResponseEntity<Crime[]> assault = restTemplate.exchange(
//				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13001", HttpMethod.GET, entity,
//				Crime[].class);
//
//		ResponseEntity<Crime[]> robbery = restTemplate.exchange(
//				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=12000", HttpMethod.GET, entity,
//				Crime[].class);
		int [] countArr16= countCrimesByCategory2016(42.335972, -83.050057);
		int [] countArr18= countCrimesByCategory2018(42.335972, -83.050057);
		String finalScore = sumScoreCategories(countArr16, countArr18);
		
		ModelAndView mv = new ModelAndView("crimetable");
		mv.addObject("finalScoreTest", finalScore);
		mv.addObject("aggravatedAssault", crimesNearAddress18(42.335972, -83.050057));
		mv.addObject("crimeCountsss", countCrimesByCategory2018(42.335972, -83.050057));
		mv.addObject("crimeCounts", countCrimesByCategory2016(42.335972, -83.050057));
		return mv;
	}

	public void SexualOffenses() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> firstDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> secondDegree = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=11007", HttpMethod.GET, entity,
				Crime[].class);

	}

	public void theftOffense() {
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

	}

	public static ArrayList<Crime> crime2016() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> twentySixteen = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?year=2016", HttpMethod.GET, entity, Crime[].class);
		ArrayList<Crime> list2016 = new ArrayList<Crime>();
		for (Crime c : twentySixteen.getBody()) {
			if (c.getOffenseCategory().equals("LARCENY") || c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE") || c.getOffenseCategory().contains("SEX")
					|| c.getOffenseCategory().equals("ROBBERY") || c.getOffenseCategory().equals("ASSAULT")
					|| c.getOffenseCategory().equals("AGGRAVATED ASSAULT")) {
				list2016.add(c);
			}
		}
		System.out.println(list2016.size());

		return list2016;
	}

	public static ArrayList<Crime> crime2018() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> twentyEighteen = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?year=2018", HttpMethod.GET, entity, Crime[].class);
		ArrayList<Crime> list2018 = new ArrayList<Crime>();

		for (Crime c : twentyEighteen.getBody()) {
			if (c.getOffenseCategory().equals("LARCENY") || c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE") || c.getOffenseCategory().contains("SEX")
					|| c.getOffenseCategory().equals("ROBBERY") || c.getOffenseCategory().equals("ASSAULT")
					|| c.getOffenseCategory().equals("AGGRAVATED ASSAULT")) {
				list2018.add(c);
			}

		}
		System.out.println(list2018.size());

		return list2018;
	}

	public static int[] countCrimesByCategory2016(double userLat, double userLong) {
		int vCount = 0;
		int tCount = 0;
		int sCount = 0;
		// TO-DO pass in user address lat/long values
		 ArrayList<Crime> crimesInRange = crimesNearAddress16(userLat, userLong);
		//ArrayList<Crime> crimesInRange = crime2016();
		for (Crime c : crimesInRange) {
			if (c.getOffenseCategory().equals("LARCENY") || c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE")) {
				tCount++;
			} else if (c.getOffenseCategory().contains("SEX")) {
				sCount++;
			} else {
				vCount++;
			}

		}
		int[] counts2016 = { vCount, sCount, tCount, crimesInRange.size() };
		// sysout for testing
		System.out.println(vCount);
		System.out.println(sCount);
		System.out.println(tCount);
		System.out.println(crimesInRange.size());
		return counts2016;
	}

	public static int[] countCrimesByCategory2018(double userLat, double userLong) {
		int vCount = 0;
		int tCount = 0;
		int sCount = 0;
		// TO-DO pass in user address lat/long values
		 ArrayList<Crime> crimesInRange = crimesNearAddress18(userLat, userLong);
		//ArrayList<Crime> crimesInRange = crime2018();
		for (Crime c : crimesInRange) {
			if (c.getOffenseCategory().equals("LARCENY") || c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE")) {
				tCount++;
			} else if (c.getOffenseCategory().contains("SEX")) {
				sCount++;
			} else {
				vCount++;
			}

		}
		int[] counts2018 = { vCount, sCount, tCount, crimesInRange.size() };
		// sysout for testing
		System.out.println(vCount);
		System.out.println(sCount);
		System.out.println(tCount);
		System.out.println(crimesInRange.size());
		return counts2018;

	}

	// for 2016 crimes in range
	public static ArrayList<Crime> crimesNearAddress16(double userLat, double userLong) {
		ArrayList<Crime> crimesByYear = crime2016();
		ArrayList<Crime> crimesInRange = new ArrayList<Crime>();
		for (Crime c : crimesByYear) {
			double distance = UtilityClass.distFrom(userLat, userLong, c.getLatitude(), c.getLongitude());
			if (distance < 0.26) {
				crimesInRange.add(c);
			}
		}

		return crimesInRange;

	}

	// for 2018 crimes in range
	public static ArrayList<Crime> crimesNearAddress18(double userLat, double userLong) {
		ArrayList<Crime> crimesByYear = crime2018();
		ArrayList<Crime> crimesInRange = new ArrayList<Crime>();
		for (Crime c : crimesByYear) {
			double distance = UtilityClass.distFrom(userLat, userLong, c.getLatitude(), c.getLongitude());
			if (distance < 0.26) {
				crimesInRange.add(c);
			}
		}

		return crimesInRange;

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
	public static int calculateCrimeScore(int scoreWeight, int crime2016, int crime2018) {
		int score = 25;
		System.out.println("**" + crime2016);
		System.out.println("****" + crime2018);
		// neighborhood gets full points if crime is zero
		if (crime2018 == 0) {
			score = scoreWeight;
			return score;
		} 
		// neighborhood gets half points for no increase or decrease in crime
		else if (crime2016 == crime2018) {
			score = scoreWeight / 2;
			return score;
		} 
		// neighborhood gets more points for greater decrease in crime
		else if (crime2016 > crime2018) {
			int decrease = calculateDecrease(crime2016, crime2018);
			if (decrease >= 50) {
				score += scoreWeight;
				return score;
			} else if (decrease >= 25) {
				score = scoreWeight * (3 / 4);
				return score;
			} else if (decrease >= 1) {
				score = scoreWeight * (3 / 5);
				return score;
			}
		}
		// neighborhood gets less points for greater increase in crime
		else if (crime2016 < crime2018) {
			int increase = calculateIncrease(crime2016, crime2018);
			if (increase >= 50) {
				score = 0;
				return score;
			} else if (increase >= 25) {
				score = scoreWeight * (1 / 4);
				return score;
			} else if (increase >= 1) {
				score = scoreWeight * (2 / 5);
				return score;
			}
		}
		return score;
	}
	
	public static String sumScoreCategories(int[] crime2016, int[] crime2018) {
		
		int vScore = calculateCrimeScore(20, crime2016[0], crime2018[0]);
		System.out.println("vScore = " + vScore);
		int sScore = calculateCrimeScore(20, crime2016[1], crime2018[1]);
		int tScore = calculateCrimeScore(20, crime2016[2], crime2018[2]);
		int overallScore = calculateCrimeScore(40, crime2016[3], crime2018[3]);
		int sumScores = vScore + sScore + tScore + overallScore;
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
		System.out.println("vScore = " + vScore);
		System.out.println("sScore = " + sScore);
		System.out.println("tScore = " + tScore);
		System.out.println("overallScore = " + overallScore);
		System.out.println("sum = " + sumScores);
		System.out.println(grade);
		
		return grade;
	}
	
}
