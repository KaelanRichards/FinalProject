package com.finalproject.FinalProject.controller;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.FinalProject.entity.Crime;
import com.finalproject.FinalProject.entity.greenlight.Coordinates;
import com.finalproject.FinalProject.util.UtilityClass;

@Controller
public class GreenLightController {
	
	@RequestMapping("/greenlighttest")
	public ModelAndView GreenLight(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng) {
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Coordinates[]> GLresult = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/xgha-35ji.json" , HttpMethod.GET, entity,
				Coordinates[].class);
		
//		GreenLightJson[] result2 = restTemplate.getForObject(
//				"https://data.detroitmi.gov/resource/xgha-35ji.json",GreenLightJson[].class);
		
		ArrayList<Coordinates> result3 = new ArrayList <Coordinates>();
		for (Coordinates c : GLresult.getBody()) {
			result3.add(c);
		}
		
		ArrayList<Coordinates> glInRange = new ArrayList<Coordinates>();
		for (Coordinates c : result3) {
			double distance = UtilityClass.distFrom(lat, lng, c.getLat(), c.getLng());
			if (distance < 1.00) {
				glInRange.add(c);
			}
		}
		
		
		
		return new ModelAndView("results", "gl", glInRange);
	
	
	
	}
}

