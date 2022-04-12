package com.blog.app.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.blog.app.servicesInerfaces.ErrorService;

@Controller
public class MyErrorController implements ErrorController{

	@Autowired
	ErrorService errorService;
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		return errorService.redirectToRightErrorPage(request);
	}
	
	public String getErrorPath() {
		return "/error";
	}
}
