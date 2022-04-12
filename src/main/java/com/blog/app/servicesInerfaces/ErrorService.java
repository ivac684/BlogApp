package com.blog.app.servicesInerfaces;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface ErrorService {

	String redirectToRightErrorPage(HttpServletRequest request);
}
