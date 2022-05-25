package com.study.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //해당 클래스의 기본생성자 생성해주는 어노테이션
@Entity
public class Board {
	
	@Id //pk 의미
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private int hits;
	
	private char deleteYn;
	
	private LocalDateTime createdDate = LocalDateTime.now(); //생성일
	
	private LocalDateTime modifiedDate; //수정일
	
	@Builder
	public Board(String title, String content, String writer, int hits, char deleteYn) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hits = hits;
		this.deleteYn = deleteYn;
	}
	
	/*
	 * 게시글 수정
	 */
	public void update(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.modifiedDate = LocalDateTime.now();
	}
	
	/*
	 * 조회 수 증가
	 */
	public void increaseHits() {
		this.hits++;
	}
	
	/*
	 * 게시글 삭제
	 */
	public void delete() {
		this.deleteYn = 'Y';
	}
}
