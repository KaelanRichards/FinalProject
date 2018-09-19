package com.finalproject.FinalProject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;

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
@SessionAttributes("user")
public class CrimeController {

	@Value("${geocode.key}")
	String geocodeKey;

//	@RequestMapping("/crimetable")
//	public ModelAndView crimeDataTest() {
//
//		int[] totals2016 = CrimeUtility.getCrimeTotals("2016", 42.335972, -83.050057);
//		int[] totals2017 = CrimeUtility.getCrimeTotals("2017", 42.335972, -83.050057);
//		int[] totals2018 = CrimeUtility.getCrimeTotals("2018", 42.335972, -83.050057);
//		String finalScore = CrimeUtility.sumScoreCategories(totals2016, totals2018);
//		System.out.println(Arrays.toString(totals2016));
//		System.out.println(Arrays.toString(totals2017));
//		System.out.println(Arrays.toString(totals2018));
//
//		ModelAndView mv = new ModelAndView("crimetable");
//		mv.addObject("finalScoreTest", finalScore);
//
//		return mv;
//	}

	// this is the GEOCODE API
	@RequestMapping("/result")
	public ModelAndView Geo(@RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state) { // HttpSession session
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		// session.setAttribute("address", address);
		RestTemplate restTemplate = new RestTemplate();

		GeoJson result = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?address="
				+ address + city + state + "&key=" + geocodeKey, GeoJson.class);
		// real address :
		// https://maps.googleapis.com/maps/api/geocode/json?address=1750WoodwardAveDetroitMI&key=AIzaSyC4_ZSaexxdhNL2hP_MJ4t4vTRUVpigN1Y
		System.out.println(result);

		Double latitude = result.getResults().get(0).getGeometry().getLocation().getLat();
		Double longitude = result.getResults().get(0).getGeometry().getLocation().getLng();


		ResponseEntity<GreenLightJson[]> GLresult = restTemplate.exchange(
				"https://data.detroitmi.gov/resource/xgha-35ji.json", HttpMethod.GET, entity, GreenLightJson[].class);

		ArrayList<GreenLightJson> result3 = new ArrayList<GreenLightJson>();
		for (GreenLightJson c : GLresult.getBody()) {
			// System.out.println(c);
			result3.add(c);
		}

		ArrayList<GreenLightJson> glInRange = new ArrayList<GreenLightJson>();

		for (int i = 2; i < result3.size(); i++) {
			double distance = UtilityClass.distFrom(latitude, longitude,
					Double.parseDouble(GLresult.getBody()[i].getLocation().getCoordinates().get(1)),
					Double.parseDouble(GLresult.getBody()[i].getLocation().getCoordinates().get(0)));
			if (distance < 1) {
				glInRange.add(result3.get(i));

			}
		}

		ModelAndView mv = new ModelAndView("results");


		SortedSet<java.util.Map.Entry<String, Double>> precincts = UtilityClass.precinctsNearAddress(latitude,
				longitude);
		double precinctDistance = precincts.first().getValue();
		String precinctName = precincts.first().getKey();
		String yourPrecinctDistance = String.format("%.2f", precinctDistance) + " miles away";
		int localAverage = (int) AverageCrimeUtility.averageTotalLocalCrimeList(latitude, longitude);
		int allAverage = (int) AverageCrimeUtility.averageTotalCrimeList();
		String percentage = AverageCrimeUtility.calculateSafetyPercentage(allAverage, localAverage);
		String[] precinctInfo = returnPrecinctInformation(precinctName);
		
		mv.addObject("stolenVehicle", CrimeUtility.localCrimeOffense(24001, "2018", latitude, longitude).size());
		mv.addObject("larceny", CrimeUtility.localCrimeOffense(23007, "2018", latitude, longitude).size());
		mv.addObject("burglary", CrimeUtility.localCrimeOffense(22001, "2018", latitude, longitude).size());
		mv.addObject("aggravatedAssault", CrimeUtility.localCrimeOffense(13002, "2018", latitude, longitude).size());
		mv.addObject("assault", CrimeUtility.localCrimeOffense(13001, "2018", latitude, longitude).size());
		mv.addObject("robbery", CrimeUtility.localCrimeOffense(1200, "2018", latitude, longitude).size());
		mv.addObject("sexualAssault", CrimeUtility.localCrimeOffense(11001, "2018", latitude, longitude).size() + CrimeUtility.localCrimeOffense(11007, "2018", latitude, longitude).size());
	
		
		mv.addObject("precinctInfo", precinctInfo);
		mv.addObject("yourPrecinct", yourPrecinctDistance);
		mv.addObject("yourPrecinctName", precinctName);
		mv.addObject("GLlist", glInRange);
		mv.addObject("safetyString", percentage);
		mv.addObject("address", address);
		System.out.println(allAverage);

		return mv;

		// ORDER IS : json -> results -> geometry -> location -> lat&lng
	}

	public String[] returnPrecinctInformation(String precinctName) {
		String[] info = new String[5];
		// switch statement with int data type
		switch (precinctName) {
		case "downtownservice":
			info[0] = "Downtown Services";
			info[1] = "20 Atwater Street Detroit, MI 48226";
			info[2] = "Captain Conway Petty: (313) 237-2850 Officer Angela Hollis (313)590-0186 & Officer Steven Shank (313)643-0381";
			return (info);
		case "2nd":
			info[0] = "2nd Police Station";
			info[1] = "13530 Lesure Street Detroit, MI 48227";
			info[2] = "Commander Mounsey (313) 596-5200 & Officer Burks Collette Burks (313)600-5756 & Officer Yolanda Sharpe (313)573-03771";
			return (info);
		case "3rd":
			info[0] = "3rd Police Station";
			info[1] = "2875 W. Grand Boulevard Detroit, MI 48202";
			info[2] = "Commander Giaquinto (313) 596-5300, Officer Carrie Thomas (313)590-4327, Officer Gilbert Munoz (313)643-0897, Officer Dale Dorsey (313)643-0865, & Officer Tamyra Harris-Hardy (313)570-4364";
			return (info);
		case "4th":
			info[0] = "4th Police Station";
			info[1] = "13530 Lesure Street Detroit, MI 48227";
			info[2] = "Commander Walton (313) 596-5400 Officer Juan Lebron (313)643-0354, Officer Alfonzo Ruiz (313)618-1695, & Officer Thomas Denmark (313)643-0225";
			return (info);
		case "5th":
			info[0] = "5th Police Station";
			info[1] = "3500 Conner Avenue Detroit MI 48215";
			info[2] = "Commander Ewing (313) 596-5500 Officer Deborah Gaines (313)643-0202, Officer Audrey Curtis (313)643-0202, & Officer Herman King (313)643-0689";
			return (info);
		case "6th":
			info[0] = "6th Police Station";
			info[1] = "11450 Warwick Street Detroit MI 48228";
			info[2] = "Commander Tosqui (313) 596-5600 Officer Heather Ivey (313)643-0055, Officer Charles Staples (313)643-0481, & Officer Michael Gordon (313)643-0052";
			return (info);
		case "7th":
			info[0] = "7th Police Station";
			info[1] = "3501 Chene Street Detroit MI 48207";
			info[2] = "Commander Williams (313) 596-5700 Officer Samuel Balogun (313)643-0608, Officer Shawn Duncan (313)643-0711, & Officer Joseph Corbett (313)643-0699";
			return (info);
			
		case "8th":
			info[0] = "8th Police Station";
			info[1] = "21555 W. McNichols Road , MI 48227 Detroit, MI 48219";
			info[2] = "Commander Pritchett (313) 596-5800 Officer Shawn Childrey (313)590-5199, Officer Baron Coleman (313)643-0773, Officer Tanda Rawls-Owens (313)643-0501, & Officer Corey Marshall (313)643-0752";
			return (info);

		case "9th":
			info[0] = "9th Police Station";
			info[1] = "11187 Gratiot Avenue Detroit MI 48213";
			info[2] = "Commander Mahone (313) 596-5900 Officer Brad Hawkins (313)643-0590, Officer Aubrey Wade (313)618-0785, Officer Abraham Blue (313)590-0484, & Officer Jay Dantzler (313)590-6611";
			return (info);

		case "10th":
			info[0] = "10th Police Station";
			info[1] = "12000 Livernois Avenue Detroit MI 48206";
			info[2] = "Commander Kyriacou (313) 596-1000 Officer Della Brown (313)614-9440 & Officer Roberto Berry (313)618-0793";
			return (info);
			
		case "11th":
			info[0] = "11th Police Station";
			info[1] = "5100 E. Nevada Avenue Detroit MI 48234";
			info[2] = "Commander Leach (313) 596-1100 Officer Kevin Chambers (313)600-3354, Officer Eric Hill (313)618-0888, & Officer Douglas Nichols (313) 618-0898";
			return (info);

		case "12th":
			info[0] = "12th Police Station";
			info[1] = "1441 W. Seven Mile Road Detroit MI 48203";
			info[2] = "Commander Thomas (313) 596-1200 Officer Nathaniel Womack (313)618-1071, Officer Michael Crowder (313)573-7654, Officer Tania Anding (313)618-0767, & Officer Shannon Bullock (313)618-0787";
			return (info);
		}
		return (info);
	}
}
