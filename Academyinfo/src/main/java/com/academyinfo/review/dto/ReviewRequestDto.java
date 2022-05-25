package com.academyinfo.review.dto;

import java.time.LocalDateTime;

import com.academyinfo.Class.domain.entity.ClassEntity;
import com.academyinfo.member.domain.entity.MemberEntity;
import com.academyinfo.review.domain.entity.ReviewEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewRequestDto {
	private Integer rvindex;
	private double score;
	private String contents;
	private int report;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	private ClassEntity cindex;
	private MemberEntity mindex;
	
	public ReviewEntity toEntity() {
		ReviewEntity reviewEntity = ReviewEntity.builder()
				.rvindex(rvindex)
				.score(score)
				.contents(contents)
				.report(report)
				.createdDate(createdDate)
				.modifiedDate(modifiedDate)
				.cindex(cindex)
				.mindex(mindex)
				.build();
		
		return reviewEntity;
	}
}
