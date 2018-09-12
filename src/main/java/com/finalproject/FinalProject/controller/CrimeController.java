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

		ModelAndView mv = new ModelAndView("crimetable");
		mv.addObject("aggravatedAssault", crime2016());
		mv.addObject("crimeCounts", countCrimesByCategory2016());
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
		for(int i = 0; i < theftList.size(); i++) {
			System.out.println(theftList.get(i));
		}
		
	}
	

	public static ArrayList<Crime> crime2016() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> twentySixteen = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?year=2016", HttpMethod.GET, entity,
				Crime[].class);
		ArrayList<Crime> list2016 = new ArrayList<Crime>();
		for (Crime c : twentySixteen.getBody()) {
			if (c.getOffenseCategory().equals("LARCENY") 
					|| c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE") 
					|| c.getOffenseCategory().contains("SEX") 
					|| c.getOffenseCategory().equals("ROBBERY") 
					|| c.getOffenseCategory().equals("ASSAULT")
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
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?year=2018", HttpMethod.GET, entity,
				Crime[].class);
		ArrayList<Crime> list2018 = new ArrayList<Crime>();
		
		for (Crime c : twentyEighteen.getBody()) {
			if (c.getOffenseCategory().equals("LARCENY") 
					|| c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE") 
					|| c.getOffenseCategory().contains("SEX") 
					|| c.getOffenseCategory().equals("ROBBERY") 
					|| c.getOffenseCategory().equals("ASSAULT")
					|| c.getOffenseCategory().equals("AGGRAVATED ASSAULT")) {
				list2018.add(c);
			}
			
		}
		System.out.println(list2018.size());
		
		return list2018;
	}
	
	public static int[] countCrimesByCategory2016() {
		int vCount = 0;
		int tCount = 0;
		int sCount = 0;
		//TO-DO pass in user address lat/long values
		//ArrayList<Crime> crimesInRange = crimesNearAddress16(/*HERE*/);
		ArrayList<Crime> crimesInRange = crime2016();
		for (Crime c : crimesInRange) {
			if (c.getOffenseCategory().equals("LARCENY") 
					|| c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE")) {
				tCount++;
			}else if (c.getOffenseCategory().contains("SEX")) {
				sCount++;
			}else  {
				vCount++;
			}
			
		}
		int[] counts2016 = {vCount, sCount, tCount, crimesInRange.size()};
		//sysout for testing
		System.out.println(vCount);
		System.out.println(sCount);
		System.out.println(tCount);
		System.out.println(crimesInRange.size());
		return counts2016;
	}
	public static int[] countCrimesByCategory2018() {
		int vCount = 0;
		int tCount = 0;
		int sCount = 0;
		//TO-DO pass in user address lat/long values
		//ArrayList<Crime> crimesInRange = crimesNearAddress18(/*HERE*/);
		ArrayList<Crime> crimesInRange = crime2018();
		for (Crime c : crimesInRange) {
			if (c.getOffenseCategory().equals("LARCENY") 
					|| c.getOffenseCategory().equals("BURGLARY")
					|| c.getOffenseCategory().equals("STOLEN VEHICLE")) {
				tCount++;
			}else if (c.getOffenseCategory().contains("SEX")) {
				sCount++;
			}else  {
				vCount++;
			}
			
		}
		int[] counts2018 = {vCount, sCount, tCount, crimesInRange.size()};
		//sysout for testing
		System.out.println(vCount);
		System.out.println(sCount);
		System.out.println(tCount);
		System.out.println(crimesInRange.size());
		return counts2018;
		
	}
	// for 2016 crimes in range
	public static ArrayList<Crime> crimesNearAddress16(double userLat, double userLong){
		ArrayList<Crime> crimesByYear = crime2016();
		ArrayList<Crime> crimesInRange = new ArrayList<Crime>();
		for (Crime c : crimesByYear) {
			double distance = UtilityClass.distFrom(userLat, userLong, c.getLatitude(),c.getLongitude());
			if(distance < 0.26) {
				crimesInRange.add(c);
			}
		}
		
		return crimesInRange;
		
	}
	// for 2018 crimes in range
	public static ArrayList<Crime> crimesNearAddress18(double userLat, double userLong){
		ArrayList<Crime> crimesByYear = crime2018();
		ArrayList<Crime> crimesInRange = new ArrayList<Crime>();
		for (Crime c : crimesByYear) {
			double distance = UtilityClass.distFrom(userLat, userLong, c.getLatitude(),c.getLongitude());
			if(distance < 0.26) {
				crimesInRange.add(c);
			}
		}
		
		return crimesInRange;
		
	}
	
}
