package com.academyinfo.image.service;

import java.util.List;

import com.academyinfo.image.dto.ImageResponseDto;

public interface ImageService {
	public List<ImageResponseDto> getImage();
	public List<ImageResponseDto> search(String keyword);
}
