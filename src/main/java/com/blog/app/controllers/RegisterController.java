package com.blog.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.blog.app.entites.User;
import com.blog.app.forms.RegisterForm;
import com.blog.app.servicesInerfaces.UserService;

@Controller
@RequestMapping("/users")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	User user = new User();
	@RequestMapping("/register")
    public String register(RegisterForm registerForm) {
        return "users/register";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPage(@ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult){
		
		User localUser = userService.findByUsername(registerForm.getUsername());
		if(localUser != null || bindingResult.hasErrors())
			return "redirect:/users/register";
		 else {
			 user.setFullName(registerForm.getFullName());
			 user.setPassword(registerForm.getPassword());
			 user.setUsername(registerForm.getUsername());
			 user.setEmail(registerForm.getEmail());	 
			 userService.create(user);
		     return "redirect:/";
		 }
	 }
}
