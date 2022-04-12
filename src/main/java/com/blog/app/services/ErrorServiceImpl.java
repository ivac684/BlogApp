package com.blog.app.services;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.app.servicesInerfaces.ErrorService;

@Service
public class ErrorServiceImpl implements ErrorService{
	
	@Override
	public String redirectToRightErrorPage(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			int statusCode = Integer.parseInt(status.toString());
		
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "/errors/error404";
			}
			else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "/errors/error500";
			}
		}
		return "/errors/error";
	}

}
