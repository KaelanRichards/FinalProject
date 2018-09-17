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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.FinalProject.entity.Crime;
import com.finalproject.FinalProject.entity.geo.GeoJson;
import com.finalproject.FinalProject.util.AverageCrimeUtility;
import com.finalproject.FinalProject.util.CrimeUtility;
import com.finalproject.FinalProject.util.UtilityClass;

@Controller
public class CrimeController {

	
	@RequestMapping("/crimetable")
	public ModelAndView crimeDataTest() {

		
		int[] totals2016 = CrimeUtility.getCrimeTotals("2016", 42.335972, -83.050057);
		int[] totals2017 = CrimeUtility.getCrimeTotals("2017", 42.335972, -83.050057);
		int[] totals2018 = CrimeUtility.getCrimeTotals("2018", 42.335972, -83.050057);
		String finalScore = CrimeUtility.sumScoreCategories(totals2016, totals2018);
		System.out.println(Arrays.toString(totals2016));
		System.out.println(Arrays.toString(totals2017));
		System.out.println(Arrays.toString(totals2018));
		
		ModelAndView mv = new ModelAndView("crimetable");
		mv.addObject("finalScoreTest", finalScore);
		//mv.addObject("aggravatedAssault", masterList16);
//		mv.addObject("crimeCountsss", countCrimesByCategory2018(42.335972, -83.050057));
//		mv.addObject("crimeCounts", countCrimesByCategory2016(42.335972, -83.050057));
		return mv;
	}



	//this is the GEOCODE API
	@RequestMapping("/result")
	public ModelAndView Geo(@RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state) {
		RestTemplate restTemplate = new RestTemplate();
		GeoJson result = restTemplate.getForObject(
				"https://maps.googleapis.com/maps/api/geocode/json?address=" + address + city + state + "&key=AIzaSyC4_ZSaexxdhNL2hP_MJ4t4vTRUVpigN1Y",
				GeoJson.class);
		// real address :
		// https://maps.googleapis.com/maps/api/geocode/json?address=1750WoodwardAveDetroitMI&key=AIzaSyC4_ZSaexxdhNL2hP_MJ4t4vTRUVpigN1Y
		System.out.println(result);
		
		Double latitude = result.getResults().get(0).getGeometry().getLocation().getLat();
		Double longitude = result.getResults().get(0).getGeometry().getLocation().getLng();
		
//		int[] totals2016 = CrimeUtility.getCrimeTotals("2016", latitude, longitude);
//		int[] totals2017 = CrimeUtility.getCrimeTotals("2017", latitude, longitude);
//		int[] totals2018 = CrimeUtility.getCrimeTotals("2018", latitude, longitude);
//		String finalScore = CrimeUtility.sumScoreCategories(totals2016, totals2018);
		
		ModelAndView mv = new ModelAndView("results");
		
		mv.addObject("result", latitude + " " + longitude);
//		mv.addObject("grade", finalScore);
//		mv.addObject("scores16", Arrays.toString(totals2016));
//		mv.addObject("scores17", Arrays.toString(totals2017));
//		mv.addObject("scores18", Arrays.toString(totals2018));
		
		
		int localAverage = (int) AverageCrimeUtility.averageTotalLocalCrimeList(latitude, longitude);
		int allAverage = (int) AverageCrimeUtility.averageTotalCrimeList();
		String percentage = AverageCrimeUtility.calculateSafetyPercentage(allAverage, localAverage);
		
		mv.addObject("safetyString", percentage);
		System.out.println( "all: " + allAverage + " local: " + localAverage);
		
		return mv;
		
		//ORDER IS : json -> results -> geometry -> location -> lat&lng
	}
	

	
}
