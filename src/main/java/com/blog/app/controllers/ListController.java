package com.blog.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.blog.app.entites.Post;
import com.blog.app.entites.User;
import com.blog.app.servicesInerfaces.PostService;
import com.blog.app.servicesInerfaces.UserService;

@Controller
public class ListController {

	@Autowired
    private UserService userService;
	@Autowired
	private PostService postService;

    @GetMapping("/users/list")
    public String listUsers(Model model) {
        List<User> listUsers = userService.findAll();
        model.addAttribute("listUsers", listUsers);
         
        return "users";
    }
    @GetMapping("/posts/list")
    public String listPosts(Model model) {
        List<Post> listPosts = postService.findAll();
        model.addAttribute("listPosts", listPosts);
         
        return "listPosts";
    }
}
