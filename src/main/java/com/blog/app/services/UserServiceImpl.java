package com.blog.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.blog.app.entites.User;
import com.blog.app.repositories.UserRepository;
import com.blog.app.servicesInerfaces.UserService;

@Component
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).orElse(null);	
	}
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public User create(User user) {
		return userRepository.save(user);
	}
	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
	@Override
	public User forLogin(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		return user;
	}
}
