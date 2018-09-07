package com.finalproject.FinalProject.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

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

}
