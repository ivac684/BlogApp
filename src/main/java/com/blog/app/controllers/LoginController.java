package com.blog.app.controllers;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.blog.app.entites.User;
import com.blog.app.services.MyUserService;
import com.blog.app.servicesInerfaces.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private MyUserService myUserService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		
		User oauthUser = userService.forLogin(user.getUsername(), user.getPassword());
		if(Objects.nonNull(oauthUser)) {
			UserDetails userDetails = myUserService.loadUserByUsername(oauthUser.getUsername());
			System.err.println("User det: " + userDetails.getUsername());
			return "redirect:/";
		}
		else 
			return "redirect:/login";
	}
	@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login";
	}

}