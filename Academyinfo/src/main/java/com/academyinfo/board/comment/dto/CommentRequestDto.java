package com.academyinfo.board.comment.dto;

import java.time.LocalDateTime;

import com.academyinfo.board.comment.domain.entity.CommentEntity;
import com.academyinfo.board.freeboard.domain.entity.BoardEntity;
import com.academyinfo.member.domain.entity.MemberEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentRequestDto {
	private int cmtindex;
	private String comment;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private BoardEntity bindex;
	private MemberEntity mindex;
	
	// Dto to Entity
	public CommentEntity toEntity() {
		CommentEntity commentEntity = CommentEntity.builder()
				.cmtindex(cmtindex)
				.comment(comment)
				.createdDate(createdDate)
				.modifiedDate(modifiedDate)
				.bindex(bindex)
				.mindex(mindex)
				.build();
		
		return commentEntity;
	}
}
