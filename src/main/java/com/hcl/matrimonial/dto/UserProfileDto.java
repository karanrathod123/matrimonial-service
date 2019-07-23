package com.hcl.matrimonial.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserProfileDto {
	
	private String fullName;

	private LocalDate dob;
	
	private String address;

	private String city;

	private String nationality;

	private String gender;

	private String mobileNumber;

	private String emailId;

	private Double height;

	private Double weight;

	private String education;

	private String occupation;

	private Double annualIncome;

	private String userName;

	private String password;
	
	

}
