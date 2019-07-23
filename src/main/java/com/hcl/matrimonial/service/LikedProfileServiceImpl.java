package com.hcl.matrimonial.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.LikedProfiles;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.ResourceNotFoundException;
import com.hcl.matrimonial.repository.LikedProfilesRepository;
import com.hcl.matrimonial.repository.UserProfileRepository;

@Service
public class LikedProfileServiceImpl implements LikedProfileService {

	@Autowired
	private LikedProfilesRepository likedProfilesRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public UserProfile likePrfiles(LikeProfileDto likeProfileDto) {

		Optional<UserProfile> userProfileOptional = userProfileRepository.findById(likeProfileDto.getUserId());
		if (userProfileOptional.isPresent()) {

			LikedProfiles likedProfiles = new LikedProfiles();
			likedProfiles.setLoginUserId(userProfileOptional.get());
			Optional<UserProfile> likedUserOptional = userProfileRepository.findById(likeProfileDto.getLikedProfileId());
			if(likedUserOptional.isPresent()) {
				likedProfiles.setLikedProfileId(likedUserOptional.get());
				likedProfilesRepository.save(likedProfiles);
				return likedUserOptional.get();
			}
			throw new ResourceNotFoundException("Profile not available");

		}
		throw new ResourceNotFoundException("Invalid User id");
	}

}
