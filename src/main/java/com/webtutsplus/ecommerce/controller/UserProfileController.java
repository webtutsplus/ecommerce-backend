package com.webtutsplus.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import com.webtutsplus.ecommerce.model.UserProfile;
import com.webtutsplus.ecommerce.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webtutsplus.ecommerce.common.ApiResponse;

@RestController
@RequestMapping("/user")
public class UserProfileController {
	@Autowired private UserProfileService userProfileService;

	/**
	 * Handles GET requests to /api/user/.
	 * @return a List of user profiles wrapped in a response entity.
	 */
	@GetMapping("/")
	public ResponseEntity<List<UserProfile>> getUsers() {
		List<UserProfile> dtos = userProfileService.listProfiles();
		return new ResponseEntity<List<UserProfile>>(dtos, HttpStatus.OK);
	}

	/**
	 * Handles POST requests to /api/user/add. Used to add new users to the database.
	 * @param profile JSON object that is mappable to a UserProfile object.
	 * @return an api response wrapped in a response entity.
	 */
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addSurvey(@RequestBody @Valid UserProfile profile) {
		userProfileService.addProfile(profile);
		return new ResponseEntity<>(new ApiResponse(true, "Profile has been created."), HttpStatus.CREATED);
	}	
}
