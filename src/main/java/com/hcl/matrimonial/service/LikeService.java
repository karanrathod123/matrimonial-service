package com.hcl.matrimonial.service;

import com.hcl.matrimonial.dto.ResponseData;

public interface LikeService {

	public ResponseData getMyLikedProfiles(long userId);
}
