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
import com.finalproject.FinalProject.util.CrimeUtility;
import com.finalproject.FinalProject.util.UtilityClass;

@Controller
public class CrimeController {

	
	@RequestMapping("/crimetable")
	public ModelAndView crimeDataTest() {

		
		int[] totals2016 = CrimeUtility.getCrimeTotals("2016", 42.335972, -83.050057);
		int[] totals2018 = CrimeUtility.getCrimeTotals("2018", 42.335972, -83.050057);
		String finalScore = CrimeUtility.sumScoreCategories(totals2016, totals2018);
		System.out.println(Arrays.toString(totals2016));
		System.out.println(Arrays.toString(totals2018));
		
		ModelAndView mv = new ModelAndView("crimetable");
		mv.addObject("finalScoreTest", finalScore);
		//mv.addObject("aggravatedAssault", masterList16);
//		mv.addObject("crimeCountsss", countCrimesByCategory2018(42.335972, -83.050057));
//		mv.addObject("crimeCounts", countCrimesByCategory2016(42.335972, -83.050057));
		return mv;
	}



	
	

	
}
