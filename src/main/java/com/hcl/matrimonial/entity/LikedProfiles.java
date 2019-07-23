package com.hcl.matrimonial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class LikedProfiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "login_user_id")
	private UserProfile loginUserId;
	
	@ManyToOne
	@JoinColumn(name = "liked_profile_id")
	private UserProfile likedProfileId;
	
}
