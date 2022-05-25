package com.academyinfo.board.comment.dto;

import java.time.LocalDateTime;

import com.academyinfo.board.comment.domain.entity.CommentEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CommentResponseDto {
	private int cmtindex;
	private String comment;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private int bindex;
	private String mid;
	
	@Builder
	public CommentResponseDto(CommentEntity comment) {
			this.cmtindex = comment.getCmtindex();
			this.comment = comment.getComment();
			this.createdDate = comment.getCreatedDate();
			this.modifiedDate = comment.getModifiedDate();
			this.bindex = comment.getBindex().getFbindex();
			this.mid = comment.getMindex().getId();
	}
}
