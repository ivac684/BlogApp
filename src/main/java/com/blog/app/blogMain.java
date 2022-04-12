package com.blog.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.blog.app.repositories")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.blog.app.entites", "com.blog.app.services", "com.blog.app.servicesInterfaces", "com.blog.app.controllers", "com.blog.app.repositories", "com.blog.app.details"})
@EntityScan(basePackages="com.blog.app.entites")
public class blogMain{
	
	public static void main(String[] args){

		SpringApplication.run(blogMain.class, args);
	}
}