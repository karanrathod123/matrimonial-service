package com.hcl.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonial.entity.UserProfile;


@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
