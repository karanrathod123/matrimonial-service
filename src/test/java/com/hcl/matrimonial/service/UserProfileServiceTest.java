package com.hcl.matrimonial.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimonial.repository.UserProfileRepository;
import com.hcl.matrimonial.dto.LoginDto;
import com.hcl.matrimonial.dto.UserProfileDto;
import com.hcl.matrimonial.entity.UserProfile;


@RunWith(MockitoJUnitRunner.class)
public class UserProfileServiceTest {


	LoginDto logindto;
	UserProfile userprofile;
	

	@Mock
	UserProfileRepository userprofilerepository;

	UserProfileDto userProfileDto;

	@InjectMocks
	UserProfileService userprofileservice;	
	
	
	@Before
	public void setUp() {
		userprofile = new UserProfile();
		logindto=new LoginDto();
		
		logindto.setUserName("username");
		logindto.setPassword("password");
		
		
		userProfileDto=new UserProfileDto();
		
		userProfileDto.setAddress("Pune");
		//userprofile.setAge("34");
		userProfileDto.setAnnualIncome(6700.0);
		userProfileDto.setCity("Pune");
		userProfileDto.setDob(new Date(1993-04-01).toLocalDate());
		userProfileDto.setEducation("Msc");
		userProfileDto.setEmailId("p@gmail.com");
		userProfileDto.setFullName("Prajakta");
		userProfileDto.setGender("Female");
		userProfileDto.setHeight(5.7);
		userProfileDto.setMobileNumber("897654");
		userProfileDto.setNationality("Indian");
		userProfileDto.setOccupation("JOb");
		userProfileDto.setPassword("Praju");
		userProfileDto.setUserName("Praju");
		userProfileDto.setWeight(50.5);
		
	}
	

	@Test
	public void testLoginUserFaildSenario() {
		Mockito.when(userprofilerepository.findByUserNameAndPassword("username", "password")).thenReturn(userprofile);
		assertNotNull(userprofileservice.loginUser(logindto));
	}
	
	/*
	 * @Test public void testRegistration() {
	 * Mockito.when(userprofilerepository.save(userprofile)).thenReturn(userprofile)
	 * ; assert(userprofileservice.registerUser(userProfileDto));
	 * 
	 * }
	 */
	
	
}
