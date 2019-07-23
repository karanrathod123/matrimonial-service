package com.hcl.matrimonial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.matrimonial.dto.ResponseData;
import com.hcl.matrimonial.entity.LikedProfiles;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.repository.LikedProfilesRepository;
import com.hcl.matrimonial.repository.UserProfileRepository;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikedProfilesRepository likedProfilesRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public ResponseData getMyLikedProfiles(long userId) {
		ResponseData responseData = new ResponseData();
		Optional<UserProfile> userProfileOptional = userProfileRepository.findById(userId);
		if (userProfileOptional.isPresent()) {
			UserProfile userProfile = userProfileOptional.get();
			List<LikedProfiles> likedProfies = likedProfilesRepository.findByLoginUserId(userProfile);
			if (ObjectUtils.isEmpty(likedProfies)) {
				responseData.setHttpStatus(HttpStatus.OK);
				responseData.setMessage("You have not liked any profile yet");
				return responseData;
			}

			List<UserProfile> myLikedProfiles = new ArrayList<>();
			likedProfies.stream().forEach(profile -> myLikedProfiles.add(profile.getLikedProfileId()));
			responseData.setHttpStatus(HttpStatus.OK);
			responseData.setMessage("Your liked profiles :");
			responseData.setData(myLikedProfiles);
			return responseData;

		}

		responseData.setHttpStatus(HttpStatus.NOT_FOUND);
		responseData.setMessage("Incorrect loginId");

		return responseData;
	}

	@Override
	public ResponseData getWhoLikedMyProfiles(long userId) {
		ResponseData responseData = new ResponseData();
		Optional<UserProfile> userProfileOptional = userProfileRepository.findById(userId);
		if (userProfileOptional.isPresent()) {
			UserProfile userProfile = userProfileOptional.get();
			List<LikedProfiles> likedProfies = likedProfilesRepository.findByLoginUserId(userProfile);
			if (ObjectUtils.isEmpty(likedProfies)) {
				responseData.setHttpStatus(HttpStatus.OK);
				responseData.setMessage("No one liked your profile");
				return responseData;
			}

			List<UserProfile> whoLikedMyProfile = new ArrayList<>();
			likedProfies.stream().forEach(profile -> whoLikedMyProfile.add(profile.getLoginUserId()));
			responseData.setHttpStatus(HttpStatus.OK);
			responseData.setMessage("Your profile liked by following people :");
			responseData.setData(whoLikedMyProfile);
			return responseData;

		}

		responseData.setHttpStatus(HttpStatus.NOT_FOUND);
		responseData.setMessage("Incorrect loginId");

		return responseData;
	}

}
