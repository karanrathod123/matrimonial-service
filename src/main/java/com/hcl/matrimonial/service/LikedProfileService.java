package com.hcl.matrimonial.service;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.UserProfile;

public interface LikedProfileService {
	
	public UserProfile likePrfiles(LikeProfileDto likeProfileDto);
}
