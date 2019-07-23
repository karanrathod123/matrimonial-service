package com.hcl.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.matrimonial.entity.LikedProfiles;
import com.hcl.matrimonial.entity.UserProfile;

public interface LikedProfilesRepository extends JpaRepository<LikedProfiles, Long> {

	public LikedProfiles findByLoginUserIdAndLikedProfileId(UserProfile loginUserId, UserProfile likedProfileId);
}
