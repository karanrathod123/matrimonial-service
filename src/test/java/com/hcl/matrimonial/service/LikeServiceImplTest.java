package com.hcl.matrimonial.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.matrimonial.dto.LikeProfileDto;
import com.hcl.matrimonial.dto.ResponseData;
import com.hcl.matrimonial.entity.LikedProfiles;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.repository.LikedProfilesRepository;
import com.hcl.matrimonial.repository.UserProfileRepository;

@RunWith(MockitoJUnitRunner.class)
public class LikeServiceImplTest {
	
	@InjectMocks
	private LikeServiceImpl likeServiceImpl;
	
	@Mock
	private LikedProfilesRepository likedProfilesRepository;

	@Mock
	private UserProfileRepository userProfileRepository;
	
	List<LikedProfiles> userProfiles = new ArrayList<>();
	
	@Before
	public void setUp() {
		LikedProfiles likedProfiles = new LikedProfiles();
		UserProfile user = new UserProfile();
		user.setAddress("Aundh");
		user.setAge(24);
		user.setAnnualIncome(54000000.00);
		user.setCity("Pune");
		user.setEducation("B.Tech");
		user.setFullName("Harsimar");
		user.setGender("Female");
		user.setNationality("Indian");
		user.setDob(new Date(2019-23-07).toLocalDate());
		user.setEmailId("simarkaur1295@gmail.com");
		user.setHeight(5.5);
		user.setMobileNumber("9422390512");
		user.setOccupation("Engineer");
		user.setPassword("password");
		user.setUserName("harsimar");
		user.setWeight(52.0);
		user.setProfileId(1L);
		likedProfiles.setId(11l);
		likedProfiles.setLikedProfileId(user);
		likedProfiles.setLoginUserId(user);
		userProfiles.add(likedProfiles);
	}

	@Test
	public void testMyLikedProfilesForSuccess() {
	
		Mockito.when(userProfileRepository.findById(11l)).thenReturn(Optional.of(new UserProfile()));
		Mockito.when(likedProfilesRepository.findByLoginUserId(new UserProfile())).thenReturn(userProfiles);
		ResponseData response = likeServiceImpl.getMyLikedProfiles(11l);
		assertNotNull(response.getData());
	}
	
	@Test
	public void testMyLikedProfilesForNoLikeFound() {
	
		Mockito.when(userProfileRepository.findById(11l)).thenReturn(Optional.of(new UserProfile()));
		Mockito.when(likedProfilesRepository.findByLoginUserId(new UserProfile())).thenReturn(null);
		ResponseData response = likeServiceImpl.getMyLikedProfiles(11l);
		assertTrue(response.getMessage().equals("You have not liked any profile yet"));
	}
	
	@Test
	public void testMyLikedProfilesForNoUserIdFound() {
	
		Mockito.when(userProfileRepository.findById(11l)).thenReturn(Optional.empty());
		ResponseData response = likeServiceImpl.getMyLikedProfiles(11l);
		assertTrue(response.getMessage().equals("Incorrect loginId"));
	}
	
	@Test
	public void testWhoLikedMyProfilesForSuccess() {
	
		Mockito.when(userProfileRepository.findById(11l)).thenReturn(Optional.of(new UserProfile()));
		Mockito.when(likedProfilesRepository.findByLikedProfileId(new UserProfile())).thenReturn(userProfiles);
		ResponseData response = likeServiceImpl.getWhoLikedMyProfiles(11l);
		assertNotNull(response.getData());
	}
	
	@Test
	public void testWhoLikedMyProfilesForNoLikeFound() {
	
		Mockito.when(userProfileRepository.findById(11l)).thenReturn(Optional.of(new UserProfile()));
		Mockito.when(likedProfilesRepository.findByLikedProfileId(new UserProfile())).thenReturn(null);
		ResponseData response = likeServiceImpl.getWhoLikedMyProfiles(11l);
		assertTrue(response.getMessage().equals("No one liked your profile"));
	}
	
	@Test
	public void testWhoLikedMyProfilesForNoUserIdFound() {
	
		Mockito.when(userProfileRepository.findById(11l)).thenReturn(Optional.empty());
		ResponseData response = likeServiceImpl.getWhoLikedMyProfiles(11l);
		assertTrue(response.getMessage().equals("Incorrect loginId"));
	}
}
