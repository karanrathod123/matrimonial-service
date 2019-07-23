package com.hcl.matrimonial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.repository.LikedProfilesRepository;

public class LikedProfileServiceImpl implements LikedProfileService {
	
	@Autowired
	private LikedProfilesRepository likedProfilesRepository;

	@Override
	public List<UserProfile> likePrfiles(LikeProfileDto likeProfileDto) {
	
		return null;
	}

}
