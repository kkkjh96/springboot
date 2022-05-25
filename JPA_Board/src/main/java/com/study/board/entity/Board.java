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
@NoArgsConstructor(access = AccessLevel.PROTECTED) //�ش� Ŭ������ �⺻������ �������ִ� ������̼�
@Entity
public class Board {
	
	@Id //pk �ǹ�
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private int hits;
	
	private char deleteYn;
	
	private LocalDateTime createdDate = LocalDateTime.now(); //������
	
	private LocalDateTime modifiedDate; //������
	
	@Builder
	public Board(String title, String content, String writer, int hits, char deleteYn) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hits = hits;
		this.deleteYn = deleteYn;
	}
	
	/*
	 * �Խñ� ����
	 */
	public void update(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.modifiedDate = LocalDateTime.now();
	}
	
	/*
	 * ��ȸ �� ����
	 */
	public void increaseHits() {
		this.hits++;
	}
	
	/*
	 * �Խñ� ����
	 */
	public void delete() {
		this.deleteYn = 'Y';
	}
}
