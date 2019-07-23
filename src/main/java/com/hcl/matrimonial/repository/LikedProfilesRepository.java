package com.hcl.matrimonial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.matrimonial.entity.LikedProfiles;

public interface LikedProfilesRepository extends JpaRepository<LikedProfiles, Long> {
	
	public LikedProfiles findByLoginUserIdAndLikedProfileId(Long loginUserId, Long likedProfileId);

}
