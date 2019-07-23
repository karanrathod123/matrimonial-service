package com.hcl.matrimonial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonial.dto.LoginDto;
import com.hcl.matrimonial.service.UserProfileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserProfileController {
	
	@Autowired
	UserProfileService userservice;
	
	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody LoginDto logindto) {
		return new ResponseEntity<List<String>>(userservice.userLogin(logindto), HttpStatus.OK);
	}
	

}
