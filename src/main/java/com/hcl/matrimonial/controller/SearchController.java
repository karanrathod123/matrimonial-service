package com.hcl.matrimonial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonial.dto.SearchProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	
	@PostMapping("/profile")
	public ResponseEntity<List<UserProfile>> getSearchProfile(@RequestBody SearchProfileDto searchProfileDto) {

		return new ResponseEntity<>(searchService.getSearchProfile(searchProfileDto), HttpStatus.OK);

	}

}
