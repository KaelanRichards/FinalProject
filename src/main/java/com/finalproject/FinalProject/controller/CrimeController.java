package com.finalproject.FinalProject.controller;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.finalproject.FinalProject.entity.Crime;

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

	// Pulls Robbery, Assault, Homicide from dataset and insert into list
	public ArrayList<Crime> listOfViolentCrimes() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Crime[]> response = restTemplate.exchange("https://data.detroitmi.gov/resource/9i6z-cm98.json",
				HttpMethod.GET, entity, Crime[].class);

		ArrayList<Crime> robberyList = new ArrayList<Crime>();
		for (Crime c : response.getBody()) {
			if (c.getOffenseCategory().equals("ROBBERY")) {
				robberyList.add(c);
			}
		}

		return robberyList;

	}

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

	// @RequestMapping("/crimetable")
	public void violentCrime() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Crime[]> aggraAssault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13002", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> assault = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=13001", HttpMethod.GET, entity,
				Crime[].class);

		ResponseEntity<Crime[]> robbery = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json?arrest_charge=12000", HttpMethod.GET, entity,
				Crime[].class);

//		ModelAndView mv = new ModelAndView("crimetable");
//		mv.addObject("aggravatedAssault", aggraAssault.getBody());

		// return mv;
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
		
	}
}
