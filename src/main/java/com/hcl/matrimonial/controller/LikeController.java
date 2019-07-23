package com.hcl.matrimonial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonial.dto.ResponseData;
import com.hcl.matrimonial.service.LikeService;

@RestController
@RequestMapping("/profile")
public class LikeController {
	
	@Autowired
	private LikeService likeServiceimpl;

	@GetMapping("/mylikes")
	public ResponseEntity<Object> getMyLikedProfiles(long userId){
		
	    ResponseData response =	likeServiceimpl.getMyLikedProfiles(userId);
		return new ResponseEntity<Object>(response.getData(),response.getHttpStatus());
	}
	
	@GetMapping("/wholikedme")
	public ResponseEntity<Object> getWhoLikedMyProfiles(long userId){
		
	    ResponseData response =	likeServiceimpl.getMyLikedProfiles(userId);
		return new ResponseEntity<Object>(response.getData(),response.getHttpStatus());
	}

}