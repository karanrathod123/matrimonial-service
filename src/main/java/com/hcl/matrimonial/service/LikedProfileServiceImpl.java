package com.hcl.matrimonial.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.LikedProfiles;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.InvalidInputException;
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
	public UserProfile likePrfiles(LikeProfileDto likeProfileDto) throws InvalidInputException {
		if (!likeProfileDto.getUserId().equals(likeProfileDto.getLikedProfileId())) {

			Optional<UserProfile> userProfileOptional = userProfileRepository.findById(likeProfileDto.getUserId());
			if (userProfileOptional.isPresent()) {

				LikedProfiles likedProfiles = new LikedProfiles();
				likedProfiles.setLoginUserId(userProfileOptional.get());
				Optional<UserProfile> likedUserOptional = userProfileRepository
						.findById(likeProfileDto.getLikedProfileId());
				if (likedUserOptional.isPresent()) {
					likedProfiles.setLikedProfileId(likedUserOptional.get());
					if (null == likedProfilesRepository.findByLoginUserIdAndLikedProfileId(
							userProfileOptional.get(), likedUserOptional.get())) {
						likedProfilesRepository.save(likedProfiles);
					}
					return likedUserOptional.get();
				}
				throw new ResourceNotFoundException("Liked Profile id is invalid");

			}
			throw new ResourceNotFoundException("Invalid User id");
		}
		throw new InvalidInputException("User id and liked profile id should not be same");

	}

}
