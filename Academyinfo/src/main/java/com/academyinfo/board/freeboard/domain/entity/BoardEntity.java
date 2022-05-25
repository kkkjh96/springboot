package com.academyinfo.board.freeboard.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.academyinfo.board.comment.domain.entity.CommentEntity;
import com.academyinfo.common.entity.TimeEntity;
import com.academyinfo.member.domain.entity.MemberEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "freeboard")
public class BoardEntity extends TimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fbindex;
	
	@Column(length = 20, nullable = false) 
	private String title;
	
	// @Column(length = 200, nullable = false)
	@Column(columnDefinition = "TEXT", nullable = false)
	private String contents;
	
	@Column(columnDefinition = "integer default 0")
	private int count;
	
	
	// Member와 N:1조인
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MINDEX")
	private MemberEntity mindex;
	
	/*
	 * @Column
	 * private String writer;
	 */
	
	@OneToMany(mappedBy = "bindex", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<CommentEntity> cmtindex;
	
	@Builder
	public BoardEntity(int fbindex, String title, String contents, int count, MemberEntity mindex, List<CommentEntity> cmtindex) {
		this.fbindex = fbindex;
		this.title = title;
		this.contents = contents;
		this.count = count;
		// 댓글기능 테스트
		this.mindex = mindex;
		this.cmtindex = cmtindex;
	}
}
