package com.finalproject.FinalProject.controller;

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

		mv.addObject("test", response.getBody());
		System.out.println(Arrays.toString(response.getBody()));
		
		return mv;
	}

}
