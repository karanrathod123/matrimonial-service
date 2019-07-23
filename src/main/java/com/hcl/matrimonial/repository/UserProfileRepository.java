package com.hcl.matrimonial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonial.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	@Query(value = "Select * from user_profile u WHERE " + "LOWER(u.address) LIKE LOWER(CONCAT('%', :address, '%')) AND"
			+ " LOWER(u.age) LIKE LOWER(CONCAT('%',:age, '%')) AND"
			+ " LOWER(u.annual_income) LIKE LOWER(CONCAT('%',:income, '%')) AND"
			+ " LOWER(u.city) LIKE LOWER(CONCAT('%',:city, '%'))AND"
			+ " LOWER(u.education) LIKE LOWER(CONCAT('%',:education, '%')) AND"
			+ " LOWER(u.full_name) LIKE LOWER(CONCAT('%',:fullName, '%')) AND"
			+ " LOWER(u.gender) LIKE LOWER(CONCAT('%',:gender, '%')) AND"
			+ " LOWER(u.nationality) LIKE LOWER(CONCAT('%',:nationality, '%'))", nativeQuery = true)
	public List<UserProfile> findBySearchTerm(String address, String age, String income, String city, String education,
			String fullName, String gender, String nationality);
}