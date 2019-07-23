package com.hcl.matrimonial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.UserProfile;


public interface LikedProfileService {
	
	public List<UserProfile> likePrfiles(LikeProfileDto likeProfileDto);
}
