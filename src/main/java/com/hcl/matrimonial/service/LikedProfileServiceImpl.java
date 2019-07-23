package com.hcl.matrimonial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.repository.LikedProfilesRepository;

@Service
public class LikedProfileServiceImpl implements LikedProfileService {

	@Override
	public List<UserProfile> likePrfiles(LikeProfileDto likeProfileDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * @Autowired private LikedProfilesRepository likedProfilesRepository;
	 * 
	 * @Override public List<UserProfile> likePrfiles(LikeProfileDto likeProfileDto)
	 * {
	 * 
	 * return null; }
	 */

}
