package com.hcl.matrimonial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.service.LikedProfileService;

@RestController
public class LikedProfileController {

	@Autowired
	private LikedProfileService likedProfileService;
	
	@PostMapping("/profile/like")
	public ResponseEntity<?> likeProfile(@RequestBody LikeProfileDto profileDto) {
		likedProfileService.likePrfiles(profileDto);
		
		return null;
	}
}
