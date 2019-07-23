package com.hcl.matrimonial.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.entity.LikedProfiles;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.InvalidInputException;
import com.hcl.matrimonial.exception.ResourceNotFoundException;
import com.hcl.matrimonial.repository.LikedProfilesRepository;
import com.hcl.matrimonial.repository.UserProfileRepository;

@RunWith(MockitoJUnitRunner.class)
public class LikedProfileServiceImplTest {

	@InjectMocks
	private LikedProfileServiceImpl likedProfileServiceImpl;

	@Mock
	private LikedProfilesRepository likedProfilesRepository;

	@Mock
	private UserProfileRepository userProfileRepository;

	private LikeProfileDto likeProfileDto;

	private UserProfile userProfile;

	private UserProfile likedUserProfile;

	private LikedProfiles likedProfiles;

	@Before
	public void setUp() {
		likeProfileDto = new LikeProfileDto();
		likeProfileDto.setUserId(Long.valueOf(1));
		likeProfileDto.setLikedProfileId(Long.valueOf(2));

		userProfile = new UserProfile();
		userProfile.setProfileId(Long.valueOf(1));

		likedProfiles = new LikedProfiles();
		likedUserProfile = new UserProfile();
		likedUserProfile.setProfileId(Long.valueOf(2));

	}

	@Test
	public void testLikeProfileSuccess() throws InvalidInputException {
		when(userProfileRepository.findById(likeProfileDto.getUserId())).thenReturn(Optional.of(userProfile));
		when(userProfileRepository.findById(likeProfileDto.getLikedProfileId())).thenReturn(Optional.of(userProfile));
		assertNotNull(likedProfileServiceImpl.likePrfiles(likeProfileDto));
	}

	@Test
	public void testLikeProfileWhenAlreadyAvailable() throws InvalidInputException {
		when(userProfileRepository.findById(likeProfileDto.getUserId())).thenReturn(Optional.of(userProfile));
		when(userProfileRepository.findById(likeProfileDto.getLikedProfileId())).thenReturn(Optional.of(userProfile));
		assertNotNull(likedProfileServiceImpl.likePrfiles(likeProfileDto));
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testLikeProfileWhenUserIdInvalid() throws InvalidInputException {
		when(userProfileRepository.findById(likeProfileDto.getUserId())).thenReturn(Optional.empty());
		// when(userProfileRepository.findById(likeProfileDto.getLikedProfileId())).thenReturn(Optional.of(userProfile));
		// when(likedProfilesRepository.findByLoginUserIdAndLikedProfileId(userProfile,likedUserProfile
		// )).thenReturn(null);
		likedProfileServiceImpl.likePrfiles(likeProfileDto);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testLikeProfileWhenLikedProfileIdInvalid() throws InvalidInputException {
		when(userProfileRepository.findById(likeProfileDto.getUserId())).thenReturn(Optional.of(userProfile));
		when(userProfileRepository.findById(likeProfileDto.getLikedProfileId())).thenReturn(Optional.empty());
		// when(likedProfilesRepository.findByLoginUserIdAndLikedProfileId(userProfile,likedUserProfile
		// )).thenReturn(null);
		likedProfileServiceImpl.likePrfiles(likeProfileDto);
	}

	@Test(expected = InvalidInputException.class)
	public void testLikeProfileWhenIdsAreSame() throws InvalidInputException {
		likeProfileDto.setLikedProfileId(Long.valueOf(1));
		likedProfileServiceImpl.likePrfiles(likeProfileDto);
	}

}
