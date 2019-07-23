package com.hcl.matrimonial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.dto.ResponseData;
import com.hcl.matrimonial.dto.SearchProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.InvalidInputException;
import com.hcl.matrimonial.service.LikeService;
import com.hcl.matrimonial.service.LikedProfileService;
import com.hcl.matrimonial.service.SearchService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private SearchService searchService;

	@Autowired
	private LikedProfileService likedProfileService;

	@Autowired
	private LikeService likeServiceimpl;

	@PostMapping("/search")
	public ResponseEntity<List<UserProfile>> getSearchProfile(@RequestBody SearchProfileDto searchProfileDto) {
		return new ResponseEntity<List<UserProfile>>(searchService.getSearchProfile(searchProfileDto), HttpStatus.OK);
	}

	@PostMapping("/like")
	public ResponseEntity<UserProfile> likeProfile(@RequestBody LikeProfileDto profileDto)
			throws InvalidInputException {
		return new ResponseEntity<>(likedProfileService.likePrfiles(profileDto), HttpStatus.CREATED);
	}

	@GetMapping("/mylikes")
	public ResponseEntity<Object> getMyLikedProfiles(long userId) {

		ResponseData response = likeServiceimpl.getMyLikedProfiles(userId);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

	@GetMapping("/wholikedme")
	public ResponseEntity<Object> getWhoLikedMyProfiles(long userId) {

		ResponseData response = likeServiceimpl.getWhoLikedMyProfiles(userId);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

}
