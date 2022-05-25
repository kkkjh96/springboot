package com.academyinfo.image.dto;

import com.academyinfo.image.domain.entity.ImageEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ImageRequestDto {
	private int iindex;
	private String name;
	private String path;
	
	public ImageEntity toEntity() {
		ImageEntity imageEntity = ImageEntity.builder()
				.iindex(iindex)
				.name(name)
				.path(path)
				.build();
		
		return imageEntity;
	}
}
