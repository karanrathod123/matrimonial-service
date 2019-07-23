package com.hcl.matrimonial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.SearchProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.repository.UserProfileRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	UserProfileRepository userProfileRepository;
	
	  @Override public List<UserProfile> getSearchProfile(SearchProfileDto
	  searchProfileDto) { return null; }
	 
	

}
