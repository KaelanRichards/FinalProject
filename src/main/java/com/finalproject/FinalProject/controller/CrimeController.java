package com.finalproject.FinalProject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.FinalProject.entity.geo.GeoJson;
import com.finalproject.FinalProject.entity.greenlight.GreenLightJson;
import com.finalproject.FinalProject.util.AverageCrimeUtility;
import com.finalproject.FinalProject.util.CrimeUtility;
import com.finalproject.FinalProject.util.UtilityClass;

@Controller
@SessionAttributes({"user", "address"})
public class CrimeController {

	@Value("${geocode.key}")
	String geocodeKey;
	
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
			@RequestParam("state") String state, HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		session.setAttribute("address", address);
		RestTemplate restTemplate = new RestTemplate();
		
		GeoJson result = restTemplate.getForObject(
				"https://maps.googleapis.com/maps/api/geocode/json?address=" + address + city + state + "&key="+ geocodeKey,
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
		
		ResponseEntity<GreenLightJson[]> GLresult = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/xgha-35ji.json", HttpMethod.GET, entity, GreenLightJson[].class);
		
		ArrayList<GreenLightJson> result3 = new ArrayList<GreenLightJson>();
		for (GreenLightJson c : GLresult.getBody()) {
			//System.out.println(c);
			result3.add(c);
		}

		ArrayList<GreenLightJson> glInRange = new ArrayList<GreenLightJson>();

		for (int i = 2; i < result3.size();i++ ) {
			double distance = UtilityClass.distFrom(latitude, longitude,Double.parseDouble(GLresult.getBody()[i].getLocation().getCoordinates().get(1)), Double.parseDouble(GLresult.getBody()[i].getLocation().getCoordinates().get(0)));
			if (distance < 1) {
				glInRange.add(result3.get(i));
				
			}
		}
		
		ModelAndView mv = new ModelAndView("results");
		
//		mv.addObject("result", latitude + " " + longitude);
//		mv.addObject("grade", finalScore);
//		mv.addObject("scores16", Arrays.toString(totals2016));
//		mv.addObject("scores17", Arrays.toString(totals2017));
//		mv.addObject("scores18", Arrays.toString(totals2018));
		
		SortedSet<java.util.Map.Entry<String, Double>> precincts = UtilityClass.precinctsNearAddress(latitude, longitude);
		double precinctDistance = precincts.first().getValue();
		String yourPrecinctDistance = String.format("%.2f", precinctDistance) + " miles away";
		int localAverage = (int) AverageCrimeUtility.averageTotalLocalCrimeList(latitude, longitude);
		int allAverage = (int) AverageCrimeUtility.averageTotalCrimeList();
		String percentage = AverageCrimeUtility.calculateSafetyPercentage(allAverage, localAverage);
		mv.addObject("yourPrecinct", yourPrecinctDistance);
		mv.addObject("GLlist", glInRange);
		mv.addObject("safetyString", percentage);
		System.out.println( allAverage);
		
		return mv;
		
		//ORDER IS : json -> results -> geometry -> location -> lat&lng
	}
	

	
}
