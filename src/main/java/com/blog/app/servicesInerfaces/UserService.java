package com.blog.app.servicesInerfaces;

import java.util.List;
import org.springframework.stereotype.Service;
import com.blog.app.entites.User;

@Service
public interface UserService {

	 List<User> findAll();
	 User findUserById(Long id);
	 User create(User user);
	 void deleteUserById(Long id);
	 User findByUsername(String userName);
	 User forLogin(String username, String password);
}
