package com.hcl.matrimonial.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class UserProfile implements Serializable {

	private static final long serialVersionUID = -3091977760078977105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileId;

	private String fullName;

	private LocalDate dob;

	private Integer age;

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

	@JsonIgnore
	private String userName;

	@JsonIgnore
	private String password;
}
