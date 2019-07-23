package com.hcl.matrimonial.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.LoginDto;
import com.hcl.matrimonial.dto.UserProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.exception.ResourceNotFoundException;
import com.hcl.matrimonial.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;

	public UserProfile loginUser(LoginDto logindto) {
		UserProfile userProfile = userProfileRepository.findByUserNameAndPassword(logindto.getUserName(),
				logindto.getPassword());
		if (null != userProfile) {
			return userProfile;
		}
		throw new ResourceNotFoundException("Invalid User");

	}

	public UserProfile registerUser(UserProfileDto userprofiledto) {
		UserProfile user = new UserProfile();

		LocalDate today = LocalDate.now(); // Today's date
		LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1); // Birth date

		Period p = Period.between(birthday, today);

		user.setAge(p.getYears());
		user.setAnnualIncome(userprofiledto.getAnnualIncome());
		user.setAddress(userprofiledto.getAddress());
		user.setUserName(userprofiledto.getUserName());
		user.setCity(userprofiledto.getCity());
		user.setDob(userprofiledto.getDob());
		user.setEducation(userprofiledto.getEducation());
		user.setEmailId(userprofiledto.getEmailId());
		user.setFullName(userprofiledto.getFullName());
		user.setGender(userprofiledto.getGender());
		user.setHeight(userprofiledto.getHeight());
		user.setMobileNumber(userprofiledto.getMobileNumber());
		user.setNationality(userprofiledto.getNationality());
		user.setOccupation(userprofiledto.getOccupation());
		user.setPassword(userprofiledto.getPassword());
		user.setWeight(userprofiledto.getWeight());

		List<String> listuser = new ArrayList<String>();

		return userProfileRepository.save(user);

	}
}
