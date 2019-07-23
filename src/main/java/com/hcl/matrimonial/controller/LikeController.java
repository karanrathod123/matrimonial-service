package com.hcl.matrimonial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

	@GetMapping
	public ResponseEntity<Object> getMyLikedProfiles(long userId){
		
	}
}
