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

import com.finalproject.FinalProject.entity.CallResponse;

@Controller
public class ResponseController {
	
	@RequestMapping("/responsetable")
	public ModelAndView callResponse() {
		ModelAndView mv = new ModelAndView("responsetable");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE); 
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CallResponse[]> response = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/dvu3-6qvr.json?$where=totalresponsetime!=0",
				HttpMethod.GET, entity, CallResponse[].class);

		mv.addObject("response", response.getBody());
		System.out.println(Arrays.toString(response.getBody()));
		return mv;
	}
	
}
