package com.hcl.matrimonial.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.dto.ResponseData;
import com.hcl.matrimonial.dto.SearchProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.InvalidInputException;
import com.hcl.matrimonial.service.LikeServiceImpl;
import com.hcl.matrimonial.service.LikedProfileService;
import com.hcl.matrimonial.service.SearchService;

@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {

	@InjectMocks
	private ProfileController profileController;

	@Mock
	private SearchService searchService;

	@Mock
	private LikedProfileService likedProfileService;

	@Mock
	private LikeServiceImpl likeService;

	private UserProfile userProfile;

	private List<UserProfile> userProfileList;

	@Before
	public void setUp() {
		userProfile = new UserProfile();
		userProfile.setUserName("ABC");

		userProfileList = new ArrayList<UserProfile>();
		userProfileList.add(userProfile);
	}

	@Test
	public void testGetSearchProfile() {
		// when(searchService.getSearchProfile(new
		// SearchProfileDto())).thenReturn(userProfileList);
		assertNotNull(profileController.getSearchProfile(new SearchProfileDto()));
	}

	@Test
	public void testLikeProfile() throws InvalidInputException {
		when(likedProfileService.likePrfiles(new LikeProfileDto())).thenReturn(userProfile);
		assertNotNull(profileController.likeProfile(new LikeProfileDto()));
	}

	@Test
	public void testGetMyLikedProfiles() {
		when(likeService.getMyLikedProfiles(Long.valueOf(1)))
				.thenReturn(new ResponseData("Success", HttpStatus.ACCEPTED, new Object()));
		assertNotNull(profileController.getMyLikedProfiles(Long.valueOf(1)));
	}

	@Test
	public void testGetWhoLikedMyProfiles() {
		when(likeService.getWhoLikedMyProfiles(Long.valueOf(1)))
				.thenReturn(new ResponseData("Success", HttpStatus.ACCEPTED, new Object()));
		assertNotNull(profileController.getWhoLikedMyProfiles(Long.valueOf(1)));
	}

}
