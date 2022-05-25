package com.JPA_Specification.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String tag;
	
	private int likes;
	
	protected Post() {
		
	}
	
	@Builder
	public Post(String title, String tag, int likes) {
		this.title = title;
		this.tag = tag;
		this.likes = likes;
	}
	
	@Override
	public String toString() {
		return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", likes=" + likes +
                '}';
	}
}
