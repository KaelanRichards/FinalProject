package com.finalproject.FinalProject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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

import com.finalproject.FinalProject.entity.geo.GeoJson;
import com.finalproject.FinalProject.entity.greenlight.GreenLightJson;
import com.finalproject.FinalProject.util.UtilityClass;

@Controller
public class GreenLightController {

	@RequestMapping("/test")
	public ModelAndView GreenLight(@RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state, HttpSession session) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		RestTemplate restTemplate = new RestTemplate();

		session.setAttribute("address", address);

		GeoJson result = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?address="
				+ address + city + state + "&key=AIzaSyC4_ZSaexxdhNL2hP_MJ4t4vTRUVpigN1Y", GeoJson.class);
		// real address :
		// https://maps.googleapis.com/maps/api/geocode/json?address=1750WoodwardAveDetroitMI&key=AIzaSyC4_ZSaexxdhNL2hP_MJ4t4vTRUVpigN1Y

		Double latitude = result.getResults().get(0).getGeometry().getLocation().getLat();
		Double longitude = result.getResults().get(0).getGeometry().getLocation().getLng();

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
		System.out.println(glInRange+ " " + result3);

		return new ModelAndView("results", "gl", glInRange.size());

	}


}
