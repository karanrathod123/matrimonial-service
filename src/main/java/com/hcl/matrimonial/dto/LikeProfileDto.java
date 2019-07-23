package com.hcl.matrimonial.dto;

import lombok.Data;

@Data
public class LikeProfileDto {

	private Long userId;

	private Long likedProfileId;
}
