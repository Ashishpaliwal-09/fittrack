package com.Fit.track.service.impl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fit.track.Entity.User;
import com.Fit.track.repository.UserRepository;
import com.Fit.track.service.UserService;



@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	} 
	
	@Override
	public Optional<User> getuserbyid(Long id){
		return userRepository.findById(id);
	}
	
	@Override
	public List<User>getallUsers(){
	return userRepository.findAll();
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	

	
	
	
	
	
}
