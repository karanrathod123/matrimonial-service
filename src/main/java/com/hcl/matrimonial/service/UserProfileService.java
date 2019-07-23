package com.hcl.matrimonial.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonial.dto.LoginDto;
import com.hcl.matrimonial.repository.UserProfileRepository;


@Service
public class UserProfileService {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	public List<String> loginUser(LoginDto logindto)
	{
		List<String> list=new ArrayList<String>();
		userProfileRepository.findByUserNameAndPassword(logindto.getUserName(), logindto.getPassword());
		return list;
	}

	
}
