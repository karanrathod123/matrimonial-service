package com.hcl.matrimonial.service;

import java.util.List;

import com.hcl.matrimonial.dto.SearchProfileDto;
import com.hcl.matrimonial.entity.UserProfile;

public interface SearchService {

	List<UserProfile> getSearchProfile(SearchProfileDto searchProfileDto);

}
