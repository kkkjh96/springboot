package com.academyinfo.review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academyinfo.review.domain.entity.ReviewEntity;
import com.academyinfo.review.domain.repository.ReviewRepository;
import com.academyinfo.review.dto.ReviewResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewRepository reviewRepository;
	
	//select * from review;
	@Transactional(readOnly = true)
	public List<ReviewResponseDto> getReview(){
		List<ReviewEntity> reviewEntities = reviewRepository.findAll();
		List<ReviewResponseDto> reviewDtoList = new ArrayList<>();
		
		if (reviewEntities.isEmpty()) {
	    	return reviewDtoList;
	    }

	    for (ReviewEntity reviewEntity : reviewEntities) {
	        reviewDtoList.add(this.convertEntityToDto(reviewEntity));
	    }
	    
		return reviewDtoList;
	}
	
	/* 최신 리뷰 순서로 정렬 검색 */
	@Transactional(readOnly = true)
	public List<ReviewResponseDto> getReviewByCreatedDate(){
		// reviewRepository.findOrderByCreatedDateDesc();
		Sort sort = Sort.by(
				Sort.Order.desc("createdDate")
				);
		
		
		List<ReviewEntity> reviewEntities = reviewRepository.findAll(sort);
		List<ReviewResponseDto> reviewDtoList = new ArrayList<>();
		
		if (reviewEntities.isEmpty()) {
	    	return reviewDtoList;
	    }

	    for (ReviewEntity reviewEntity : reviewEntities) {
	        reviewDtoList.add(this.convertEntityToDto(reviewEntity));
	    }
	    
		return reviewDtoList;
	}
	
	private ReviewResponseDto convertEntityToDto(ReviewEntity reviewEntity) {
	    return new ReviewResponseDto(reviewEntity);
	}
}
