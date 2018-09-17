package com.finalproject.FinalProject.controller;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.FinalProject.entity.Crime;
import com.finalproject.FinalProject.entity.Favorite;
import com.finalproject.FinalProject.entity.User;
import com.finalproject.FinalProject.repo.FavoriteRepo;
import com.finalproject.FinalProject.repo.LoginRepository;

@SessionAttributes({"user"/*, "address"*/})
@Controller
public class HomeController {

	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	FavoriteRepo favRepo;

	@RequestMapping("/")
	public ModelAndView index() {

		return new ModelAndView("index");
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		Optional<User> optionalUser = loginRepo.findByUsername(username);
		if (optionalUser.isPresent()) {
			String truePassword = optionalUser.get().getPassword();
			if (truePassword.equals(password)) {
				User user = optionalUser.get();
				session.setAttribute("user", user);
				return new ModelAndView("crimetable", "login", "Welcome back, " + user.getFirstname() + "!");
			}

		}

		// comments:
		// using optional instead of list bc it is a class, so we can compare String to
		// it later
		// logic: to find the username then match it to the corresponding pw
		// isPresent is used to see if username existed
		// we get name by ".get()" and "getPassword"
		// if the pw in sql equals to userinput , then return !

		else {
			return new ModelAndView("index", "login", "Wrong Username or Password!");
		}
		return null;

	}

	@RequestMapping("/display") // url
	public String registerPage() {
		return "display"; // string methods in the controller class return the view
	}

	@PostMapping("/User")
	public ModelAndView add(User User) {
		loginRepo.save(User);
		return new ModelAndView("redirect:/");

	}

	@RequestMapping("/search")
	public ModelAndView searchBar() {

		return new ModelAndView("search");

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

	

	
		@RequestMapping ("/favorites")
		public ModelAndView favoriteList (HttpSession session) {
			User user = (User) session.getAttribute("user");
			//need the "currentUser" to be passed in from previous page to populate our list
			System.out.println(favRepo.findByUser(user));
			return new ModelAndView ("favorites", "listFavs", favRepo.findByUser(user));
			
			
		}
		@RequestMapping("/delete/{favid}")
		public ModelAndView deleteFav(@PathVariable("favid") Long favid, HttpSession session) {
				User user = (User) session.getAttribute("user");
			
			favRepo.deleteById(favid);
			return new ModelAndView ("favorites", "listFavs", favRepo.findByUser(user));
		}
		
		@RequestMapping("/edit/{favid}")
	    public ModelAndView showEditForm(@PathVariable("favid") long favid) {
			Optional<Favorite> optHouse = favRepo.findById(favid);
			Favorite myHouse = optHouse.get();
			String address = myHouse.getAddress() + " Detroit, MI";
	        
	      
	       // mv.addObject("title", "Edit Favorite List");
	       // mv.addObject("listFavs", favRepo.findById(favid).orElse(null));
	        
	        ModelAndView mv = new ModelAndView("favoriteform");
	        mv.addObject("favoriteItem", myHouse);
	        mv.addObject("favAddress", address);
	        
	        return mv;
	    }
	    
//	    @PostMapping("/edit/{favid}/")
//	    public ModelAndView submitEditForm(Favorite favorite, @PathVariable("favid") long favid, @RequestParam ("category") String category) {
//	    	favorite.setCategory(category);
//	        favRepo.save(favorite);
//	        return new ModelAndView("redirect:/favorites");
//	    }
		
		@PostMapping("/edit")
	    public ModelAndView submitEditForm(@RequestParam("id") long id, @RequestParam("category") String c ) {
			Favorite fav = favRepo.findById(id).orElse(null);
			fav.setCategory(c);
	        favRepo.save(fav);
	        return new ModelAndView("redirect:/favorites");
	    }
		
		
		
		@RequestMapping("/add_to_my_houses")
	    public ModelAndView addNewFav(Favorite f, HttpSession session) {
				User user = (User) session.getAttribute("user");
				String address = (String) session.getAttribute("address");
				f.setAddress(address);
				f.setUser(user);
				favRepo.save(f);
				session.setAttribute("address", null);
				return new ModelAndView("redirect:/favorites");

	    }
		
}
