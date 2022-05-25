package com.academyinfo.review.dto;

import java.time.LocalDateTime;

import com.academyinfo.review.domain.entity.ReviewEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ReviewResponseDto {
	private Integer rvindex;
	private double score;
	private String contents;
	private int report;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	// class 테이블과의 조인 설정
	private String cname; // 강의명
	
	// member 테이블과의 조인 설정
	private String mid; // 작성자
	
	@Builder
	public ReviewResponseDto(ReviewEntity review) {
			this.rvindex = review.getRvindex();
			this.score = review.getScore();
			this.contents = review.getContents();
			this.report = review.getReport();
			this.createdDate = review.getCreatedDate();
			this.modifiedDate = review.getModifiedDate();
			this.cname = review.getCindex().getName();
			this.mid = review.getMindex().getId();
	}
}
