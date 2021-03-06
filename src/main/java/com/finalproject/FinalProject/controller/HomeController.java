package com.finalproject.FinalProject.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finalproject.FinalProject.entity.Favorite;
import com.finalproject.FinalProject.entity.User;
import com.finalproject.FinalProject.repo.FavoriteRepo;
import com.finalproject.FinalProject.repo.LoginRepository;

@SessionAttributes("user")
@Controller
public class HomeController {

	@Autowired
	LoginRepository loginRepo;

	@Autowired
	FavoriteRepo favRepo;

	@RequestMapping("/")
	public ModelAndView homePage() {

		return new ModelAndView("search");
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
		Optional<User> optionalUser = loginRepo.findByUsername(username);
		// optional instead of list bc it's a class and can be compared to String later
		if (optionalUser.isPresent()) {
			String truePassword = optionalUser.get().getPassword();
			// isPresent is used to see if username existed, use ".get()" and "getPassword"
			if (truePassword.equals(password)) {
				// create user object using the optional "get" method
				User user = optionalUser.get();
				// setting http session attribute to our user object
				// this tracks the user's login as long as our session lasts
				session.setAttribute("user", user);
				return new ModelAndView("search", "login", " Welcome back, " + user.getFirstname() + "!");
			}

		} else {
			return new ModelAndView("index", "login", "Wrong Username or Password!");
		}
		return null;

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		if (session.getAttribute("user") == null) {
			return new ModelAndView("search", "message", "You're not logged in. How could you possibly log out?");
		}
		// invalidate clears the current user session and starts a new one.
		session.invalidate();

		return new ModelAndView("search", "message", "Logged out.");
	}

	@RequestMapping("/display") // url
	public String registerPage() {
		return "display"; // string methods in the controller class return the view
	}

	@PostMapping("/registered")
	public ModelAndView add(User user) {
		loginRepo.save(user);
		return new ModelAndView("index");

	}

	@RequestMapping("/search")
	public ModelAndView searchBar() {

		return new ModelAndView("results");

	}

	@RequestMapping("/resources")
	public ModelAndView resources() {
		return new ModelAndView("resources");
	}

	@RequestMapping("/favorites")
	public ModelAndView favoriteList(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("search", "message",
					"You're not logged in. How could you possibly have a favorites list?");
		}
		// need the "currentUser" to be passed in from previous page to populate our
		// list

		return new ModelAndView("favorites", "listFavs", favRepo.findByUser(user));

	}

	@RequestMapping("/delete/{favid}")
	public ModelAndView deleteFav(@PathVariable("favid") Long favid, HttpSession session) {
		User user = (User) session.getAttribute("user");

		favRepo.deleteById(favid);
		return new ModelAndView("favorites", "listFavs", favRepo.findByUser(user));
	}

	@RequestMapping("/edit/{favid}")
	public ModelAndView showEditForm(@PathVariable("favid") long favid) {
		Optional<Favorite> optHouse = favRepo.findById(favid);
		Favorite myHouse = optHouse.get();
		String address = myHouse.getAddress() + " Detroit, MI";

		ModelAndView mv = new ModelAndView("favoriteform");
		mv.addObject("favoriteItem", myHouse);
		mv.addObject("favAddress", address);

		return mv;
	}

	@PostMapping("/edit")
	public ModelAndView submitEditForm(@RequestParam("id") long id, @RequestParam("category") String c) {
		Favorite fav = favRepo.findById(id).orElse(null);
		fav.setCategory(c);
		favRepo.save(fav);
		return new ModelAndView("redirect:/favorites");
	}

	@RequestMapping("/add_to_my_houses/{address}")
	public ModelAndView addNewFav(Favorite f, HttpSession session, @PathVariable("address") String address) {
		User user = (User) session.getAttribute("user");
		// String address = (String) session.getAttribute("address");
		f.setAddress(address);
		f.setUser(user);
		favRepo.save(f);
		// session.setAttribute("address", null);
		return new ModelAndView("redirect:/favorites");

	}

}
