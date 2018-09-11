package com.finalproject.FinalProject.controller;

import java.util.ArrayList;
import java.util.Arrays;

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

@Controller
public class CrimeController {
	
	
	@RequestMapping("/crimetable")
	public ModelAndView crimeTable() {
		ModelAndView mv = new ModelAndView("crimetable");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Crime[]> response = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json",
				HttpMethod.GET, entity, Crime[].class);
		for(int i = 0; i < listOfCrimes().size(); i++) {
			System.out.println(listOfCrimes().get(i));
		}
		System.out.println(listOfSexualOffenses());
		
		mv.addObject("test", response.getBody());
		//System.out.println(Arrays.toString(response.getBody()));
		
		return mv;
	}
	
	public ArrayList<Crime> listOfCrimes(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Crime[]> response = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json",
				HttpMethod.GET, entity, Crime[].class);
		
		
		ArrayList<Crime> robberyList = new ArrayList<Crime>();
		for(Crime c: response.getBody()) {
			if(c.getOffenseCategory().equals("ROBBERY")) {
				robberyList.add(c);
			}
		}
		/*for(int i = 0; i < robberyList.size(); i++) {
			System.out.println(robberyList.get(i));
		}*/
		return robberyList;
		
	}
	public ArrayList<Crime> listOfSexualOffenses(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Crime[]> response = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/9i6z-cm98.json",
				HttpMethod.GET, entity, Crime[].class);
		
		
		ArrayList<Crime> sOffenseList = new ArrayList<Crime>();
		for(Crime c: response.getBody()) {
			if(c.getOffenseCategory().contains("SEX")){
				sOffenseList.add(c);
			}
			for(int i = 0; i < sOffenseList.size(); i++) {
			System.out.println(sOffenseList.get(i));
		}
		}
		return sOffenseList;
	}

}
