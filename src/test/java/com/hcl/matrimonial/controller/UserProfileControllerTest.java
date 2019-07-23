package com.hcl.matrimonial.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimonial.dto.LoginDto;
import com.hcl.matrimonial.dto.UserProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.service.UserProfileService;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileControllerTest {

	@InjectMocks
	private UserProfileController userProfileController;
	
	@Mock
	private UserProfileService userProfileService;
	
	@Test
	public void testLoginUser() {
		when(userProfileService.loginUser(new LoginDto())).thenReturn(new UserProfile());
		assertNotNull(userProfileController.loginUser(new LoginDto()));
	}
	
	@Test
	public void testAddUser() {
		when(userProfileService.registerUser(new UserProfileDto())).thenReturn(new UserProfile());
		assertNotNull(userProfileController.addUser(new UserProfileDto()));
	}
}
