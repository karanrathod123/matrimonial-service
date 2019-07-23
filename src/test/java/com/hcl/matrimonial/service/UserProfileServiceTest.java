package com.hcl.matrimonial.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimonial.repository.UserProfileRepository;
import com.hcl.matrimonial.dto.LoginDto;
import com.hcl.matrimonial.entity.UserProfile;


@RunWith(MockitoJUnitRunner.class)
public class UserProfileServiceTest {


	LoginDto logindto;
	UserProfile userprofile;
	

	@Mock
	UserProfileRepository userprofilerepository;

	

	@InjectMocks
	UserProfileService userprofileservice;	
	
	
	@Before
	public void setUp() {
		userprofile = new UserProfile();
		logindto=new LoginDto();
		
		logindto.setUserName("username");
		logindto.setPassword("password");
		
		
	}
	

	@Test
	public void testLoginUserFaildSenario() {
		Mockito.when(userprofilerepository.findByUserNameAndPassword("username", "password")).thenReturn(userprofile);
		assertNotNull(userprofileservice.loginUser(logindto));
	}
	
}
