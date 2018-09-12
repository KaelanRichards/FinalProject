package com.finalproject.FinalProject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.FinalProject.entity.Crime;
import com.finalproject.FinalProject.entity.LoginUser;
import com.finalproject.FinalProject.entity.Results;
import com.finalproject.FinalProject.repo.LoginRepository;

@Controller
public class HomeController {

	@Autowired
	LoginRepository loginRepo;

	@RequestMapping("/")
	public ModelAndView index() {

		return new ModelAndView("index");
	}

	
	
	@RequestMapping("/login")

	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password) {
		Optional<LoginUser> optionalLoginUser = loginRepo.findByUsername(username);
		if (optionalLoginUser.isPresent()) {
			String truePassword = optionalLoginUser.get().getPassword();
			if(truePassword.equals(password)) {
				return new ModelAndView ("display", "login","Welcome back");
		}
			
		}
		
		//comments: 
		//using optional instead of list bc it is a class, so we can compare String to it later
		//logic: to find the username then match it to the corresponding pw
		//isPresent is used to see if username existed
		//we get name by ".get()" and "getPassword" 
		//if the pw in sql equals to userinput , then return !
		

		else {
		return new ModelAndView("index", "login", "Wrong Username or Password!");
		}
		return null;
		
	}
	
	@RequestMapping("/display") //url
	public String registerPage() {
		return "display"; //string methods in the controller class return the view 
	}
	
	@PostMapping("/loginuser")
	public ModelAndView add(LoginUser loginUser) {
		loginRepo.save(loginUser);
		return new ModelAndView("redirect:/");
		
	}
      
	
	
	

	@RequestMapping("/search")
	public ModelAndView results() {
		RestTemplate restTemplate = new RestTemplate();
		Results result = restTemplate.getForObject("https://data.detroitmi.gov/resource/9i6z-cm98.json", Results.class);
		ArrayList<Crime> crime = result.getResults();
		System.out.println(crime);
		return new ModelAndView("results", "mtest", crime);

	}

	@RequestMapping("/def")
	public ModelAndView definition() {
		ModelAndView mv = new ModelAndView("index");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Crime[]> response = restTemplate.exchange("https://data.detroitmi.gov/resource/9i6z-cm98.json",
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
