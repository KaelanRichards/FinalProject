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

import com.finalproject.FinalProject.entity.CallResponse;
import com.finalproject.FinalProject.entity.Crime;
import com.finalproject.FinalProject.entity.Results;



@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/search")
	public ModelAndView results(){
		RestTemplate restTemplate = new RestTemplate();
		Results result = restTemplate.getForObject("https://data.detroitmi.gov/resource/9i6z-cm98.json"  , Results.class);
		ArrayList<Crime> crime = result.getResults();
		System.out.println(crime);
		return new ModelAndView("results","mtest", crime);
		
	}
	@RequestMapping("/def")
	public ModelAndView definition() {
		ModelAndView mv = new ModelAndView("index");
		
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
//	@RequestMapping("/response911")
//	public ModelAndView callResponse() {
//		ModelAndView mv = new ModelAndView("index");
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
//		
//		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<CallResponse[]> response = restTemplate.exchange(
//				"https://data.detroitmi.gov/resource/Calls911.json",
//				HttpMethod.GET, entity, CallResponse[].class);
//
//		mv.addObject("test", response.getBody());
//		System.out.println(Arrays.toString(response.getBody()));
//		return mv;
//	}

}
