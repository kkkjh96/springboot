package com.academyinfo.board.freeboard.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.academyinfo.board.comment.domain.entity.CommentEntity;
import com.academyinfo.board.comment.dto.CommentResponseDto;
import com.academyinfo.board.freeboard.domain.entity.BoardEntity;
import com.academyinfo.member.domain.entity.MemberEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BoardResponseDto {
	private int fbindex;
	private String title;
	private String contents;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private int count;
	
	private String mid;
	private List<CommentResponseDto> comments;
	
	
	@Builder
	public BoardResponseDto(int fbindex, String title, String contents, int count, LocalDateTime createdDate, LocalDateTime modifiedDate, MemberEntity mindex, List<CommentEntity> cmtindex) {
		this.fbindex = fbindex;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.count = count;
		this.mid = mindex.getId();
		// 코멘트 List 타입을 DTO 클래스로 하여 엔티티간 무한참조 방지
		this.comments = cmtindex.stream().map(CommentResponseDto::new).collect(Collectors.toList());
	}
	
	@Builder
	public BoardResponseDto(BoardEntity boardEntity) {
		this.fbindex = boardEntity.getFbindex();
		this.title = boardEntity.getTitle();
		this.contents = boardEntity.getContents();
		this.createdDate = boardEntity.getCreatedDate();
		this.modifiedDate = boardEntity.getModifiedDate();
		this.count = boardEntity.getCount();
		this.mid = boardEntity.getMindex().getId();
		// 코멘트 List 타입을 DTO 클래스로 하여 엔티티간 무한참조 방지
		this.comments = boardEntity.getCmtindex().stream().map(CommentResponseDto::new).collect(Collectors.toList());
	}
}
