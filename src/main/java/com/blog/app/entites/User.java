package com.blog.app.entites;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 30, unique = true)
    private String username;

    @Column(name = "password", length = 60)
    private String password;

    @Column(name = "fullName", length = 100)
    private String fullName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Collection<Post> posts;
    
	@Email
	@Column(name = "email", length = 50)
	private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Collection<Post> getPosts() {
		return posts;
	}

	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
    }

	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

	public User(String username, String password, String fullName, @Email String email) {
	
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
	}
	
}