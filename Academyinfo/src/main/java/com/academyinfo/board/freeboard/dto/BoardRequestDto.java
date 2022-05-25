package com.academyinfo.board.freeboard.dto;

import java.time.LocalDateTime;
import java.util.List;

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
public class BoardRequestDto {
	private int fbindex;
	private String title;
	private String contents;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private int count;
	
	private MemberEntity mindex;
	private List<CommentEntity> cmtindex;
	
	
	public BoardEntity toEntity() {
		BoardEntity boardEntity = BoardEntity.builder()
				.fbindex(fbindex)
				.title(title)
				.contents(contents)
				.count(count)
				.mindex(mindex)
				.cmtindex(cmtindex)
				.build();
		
		return boardEntity;
	}
}
