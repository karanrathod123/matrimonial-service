package com.hcl.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.matrimonial.entity.UserProfile;

public interface SearchRepository extends JpaRepository<UserProfile, Long> {
	
	//@Query("select * from todo t where LOWER(t.)")
	
	
}
