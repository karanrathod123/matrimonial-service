package com.hcl.matrimonial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.SearchProfileDto;
import com.hcl.matrimonial.entity.UserProfile;
import com.hcl.matrimonial.repository.UserProfileRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public List<UserProfile> getSearchProfile(SearchProfileDto searchProfileDto) {
		String address = searchProfileDto.getAddress();
		Integer age=searchProfileDto.getAge();
		Double income=searchProfileDto.getAnnualIncome();
		String city =searchProfileDto.getCity();
		
		String education = searchProfileDto.getEducation();
		String fullName = searchProfileDto.getFullName();
		String gender = searchProfileDto.getGender();
		String nationality = searchProfileDto.getNationality();
		
		if(age==0&&income==0.0) {
			return userProfileRepository.findBySearchTerm(address, "", "", city, education, fullName, gender, nationality);
		}else
			if(age==0) {
				return userProfileRepository.findBySearchTerm(address, "", income+"", city, education, fullName, gender, nationality);
			}else 
				if(income==0.0) {
					return userProfileRepository.findBySearchTerm(address, age+"", "", city, education, fullName, gender, nationality);
				}
		
		return userProfileRepository.findBySearchTerm(address, age+"", income+"", city, education, fullName, gender, nationality);

	}
}
