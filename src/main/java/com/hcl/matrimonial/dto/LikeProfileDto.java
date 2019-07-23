package com.hcl.matrimonial.dto;

import java.util.List;

import lombok.Data;

@Data
public class LikeProfileDto {

	private Long userId;

	private List<Long> likedProfileIds;
}
