package com.webtutsplus.ecommerce.service;

import java.util.List;

import com.webtutsplus.ecommerce.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtutsplus.ecommerce.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired private UserProfileRepository userRepo;
	

	public void addProfile(UserProfile userProfile) {
		userRepo.save(userProfile);
	}
	
	public List<UserProfile> listProfiles(){
		return userRepo.findAll();		
	}
	
}
