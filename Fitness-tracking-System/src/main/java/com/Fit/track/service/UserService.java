package com.Fit.track.service;

import com.Fit.track.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	
    User createUser(User user);   
 
    void deleteUser(Long id);

	Optional<User> getuserbyid(Long id);

	List<User> getallUsers();
	
	
}
