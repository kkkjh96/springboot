package com.academyinfo.image.dto;

import com.academyinfo.image.domain.entity.ImageEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ImageResponseDto {
	private int iindex;
	private String name;
	private String path;
	
	@Builder
	public ImageResponseDto(int iindex, String name, String path) {
		this.iindex = iindex;
		this.name = name;
		this.path = path;
	}
	
	@Builder
	public ImageResponseDto(ImageEntity imageEntity) {
		this.iindex = imageEntity.getIindex();
		this.name = imageEntity.getName();
		this.path = imageEntity.getPath();
	}
}
