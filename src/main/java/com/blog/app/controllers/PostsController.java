package com.blog.app.controllers;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.blog.app.DTO.PostCreateDTO;
import com.blog.app.entites.Post;
import com.blog.app.entites.User;
import com.blog.app.servicesInerfaces.PostService;
import com.blog.app.servicesInerfaces.UserService;

@Controller
public class PostsController {

	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	User user;
	
	@RequestMapping("/posts")
	public String getAllPosts(Model model) {
		
		model.addAttribute("posts", postService.findAll());
		return "posts";
	}

	@GetMapping("/posts/create")
	public String createPost(Model model) {
		
		model.addAttribute("postDTO", new PostCreateDTO());
		return "posts/create";
	}
	@PostMapping("/posts/create")
	public String createPost(@ModelAttribute("postDTO") PostCreateDTO postDTO) {
		

		Post post = new Post();
		post.setId(postDTO.getId());
		post.setTitle(postDTO.getTitle());
		post.setBody(postDTO.getBody());
		post.setDate(Instant.now());
		User userpost = userService.findByUsername(postDTO.getUsername());
		if(userService.findByUsername(postDTO.getUsername()) == null)
			return "redirect:/login";
		else
			post.setAuthor(userpost);
		
		postService.save(post);
		return "redirect:/";
	}

	@GetMapping("/posts/delete")
	public String deletePost(@RequestParam Long id) {
		
		postService.deleteById(id);
		
		return "redirect:/";
	}
}