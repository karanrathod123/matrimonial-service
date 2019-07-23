package com.hcl.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.matrimonial.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
