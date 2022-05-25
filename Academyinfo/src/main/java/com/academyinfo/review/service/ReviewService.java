package com.academyinfo.review.service;

import java.util.List;

import com.academyinfo.review.dto.ReviewResponseDto;

public interface ReviewService {
	public List<ReviewResponseDto> getReview();
	public List<ReviewResponseDto> getReviewByCreatedDate();
}
