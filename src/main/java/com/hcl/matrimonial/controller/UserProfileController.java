package com.hcl.matrimonial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonial.dto.LoginDto;
import com.hcl.matrimonial.dto.UserProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.service.UserProfileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto logindto) {
		return new ResponseEntity<UserProfile>(userProfileService.loginUser(logindto), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody UserProfileDto userprofiledto) {
		return new ResponseEntity<>(userProfileService.registerUser(userprofiledto), HttpStatus.OK);
	}

}
