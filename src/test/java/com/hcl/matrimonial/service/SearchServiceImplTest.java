package com.hcl.matrimonial.service;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.matrimonial.dto.SearchProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.ResourceNotFoundException;
import com.hcl.matrimonial.repository.UserProfileRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceImplTest {

	private List<UserProfile> list;
	private SearchProfileDto searchProfileDto;
	private UserProfile user;
	
	@Mock
	UserProfileRepository userProfileRepository;
	
	@InjectMocks
	SearchServiceImpl searchService;
	
	@Before
	public void setUp() throws Exception {

	 searchProfileDto = new SearchProfileDto();
	 
	 searchProfileDto.setAddress("Aundh");
	 searchProfileDto.setAge(24);
	 searchProfileDto.setAnnualIncome(5400000.00);
	 //searchProfileDto.setCity("Pune");
	 //searchProfileDto.setEducation("B.Tech");
	 searchProfileDto.setFullName("Harsimar");
	 //searchProfileDto.setGender("Female");
	 //searchProfileDto.setNationality("Indian");
	 
	 user = new UserProfile();
	 user.setAddress("Aundh");
	 user.setAge(24);
	 user.setAnnualIncome(540000.00);
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
	 
	 list = new ArrayList<UserProfile>();
	 list.add(user);
	}

	@Test
	public void testGetSearchProfile() {
		Mockito.when(userProfileRepository.findBySearchTerm("Aundh", "24", "0.00", "", "", "Harsimar", "", "")).thenReturn(list);
		List<UserProfile> actual = searchService.getSearchProfile(searchProfileDto);
		assertNotNull(actual);
	}
	
	@Test
	public void testGetSearchProfileAgeAndIncomeAsZero() {
		searchProfileDto.setAge(0);
		searchProfileDto.setAnnualIncome(0.0);
		Mockito.when(userProfileRepository.findBySearchTerm("Aundh", "0", "0.00", "", "", "Harsimar", "", "")).thenReturn(list);
		List<UserProfile> actual = searchService.getSearchProfile(searchProfileDto);
		assertNotNull(actual);
	}
	
	@Test
	public void testGetSearchProfileAgeAsZero() {
		searchProfileDto.setAge(0);
		Mockito.when(userProfileRepository.findBySearchTerm("Aundh", "0", "54000000", "", "", "Harsimar", "", "")).thenReturn(list);
		List<UserProfile> actual = searchService.getSearchProfile(searchProfileDto);
		assertNotNull(actual);
	}
	
	@Test
	public void testGetSearchProfileIncomeAsZero() {
		searchProfileDto.setAnnualIncome(0.00);
		Mockito.when(userProfileRepository.findBySearchTerm("Aundh", "24", "0.00", "", "", "Harsimar", "", "")).thenReturn(list);
		List<UserProfile> actual = searchService.getSearchProfile(searchProfileDto);
		assertNotNull(actual);
	}
	

}
