package com.hcl.matrimonial.service;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.InvalidInputException;


public interface LikedProfileService {
	
	public UserProfile likePrfiles(LikeProfileDto likeProfileDto) throws InvalidInputException;
}
