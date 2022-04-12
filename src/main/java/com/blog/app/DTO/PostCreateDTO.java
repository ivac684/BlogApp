package com.blog.app.DTO;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Builder
public class PostCreateDTO implements Serializable  {

	private Long id;
	private String title;
	private String body;
	private String username;
	
	
	
	public PostCreateDTO() {}

	

	public PostCreateDTO(Long id, String title, String body, String username) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.username = username;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
