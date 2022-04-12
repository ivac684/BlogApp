package com.blog.app.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.blog.app.entites.Post;
import com.blog.app.entites.User;
import com.blog.app.servicesInerfaces.PostService;
import com.blog.app.servicesInerfaces.UserService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	int cntr = 0;

	@RequestMapping("/")
	public String home(Model model) {
		
		if(cntr == 0) {
			
			cntr += 1;
			return "redirect:/login";
		}
		else {
			List<Post> latest3Posts = postService.findAll().stream()
											 .limit(3).collect(Collectors.toList());
			model.addAttribute("latest3posts", latest3Posts);
			return "index";
		}
	}
}
