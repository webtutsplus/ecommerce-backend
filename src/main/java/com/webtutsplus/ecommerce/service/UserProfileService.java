package com.webtutsplus.ecommerce.service;

import java.util.List;

import com.webtutsplus.ecommerce.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtutsplus.ecommerce.repository.UserProfileRepository;

@Service
public class UserProfileService {
	@Autowired private UserProfileRepository userRepo;

	/**
	 * Used to add a new user profile to the database.
	 * @param userProfile The new user profile which we want to add.
	 */
	public void addProfile(UserProfile userProfile) {
		userRepo.save(userProfile);
	}

	/**
	 * Used to get a list of all the user profiles in the database.
	 * @return A list of all the user profiles in the database.
	 */
	public List<UserProfile> listProfiles(){
		return userRepo.findAll();		
	}
	
}
