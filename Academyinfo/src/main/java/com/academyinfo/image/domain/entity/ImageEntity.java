package com.academyinfo.image.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="imagefile")
public class ImageEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iindex;
	
	@Column
	private String name;
	
	@Column
	private String path;

	@Builder
	public ImageEntity(int iindex, String name, String path)
	{
		this.iindex = iindex;
		this.name = name;
		this.path = path;
	}
}
