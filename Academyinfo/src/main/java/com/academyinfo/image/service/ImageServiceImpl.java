package com.academyinfo.image.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.academyinfo.image.domain.entity.ImageEntity;
import com.academyinfo.image.domain.repository.ImageRepository;
import com.academyinfo.image.dto.ImageResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
	private ImageRepository imageRepository;
	
	/*추천강의(c_status가 approval이면서 점수가 제일 높은 4개의 강의) - 사진*/
	/*select * from imagefile; 전체조회 */
	public List<ImageResponseDto> getImage(){
		List<ImageEntity> imageEntities = imageRepository.findAll();
		List<ImageResponseDto> imageDtoList = new ArrayList<>();
		
		if (imageEntities.isEmpty()) {
	    	return imageDtoList;
	    }

	    for (ImageEntity imageEntity : imageEntities) {
	        imageDtoList.add(this.convertEntityToDto(imageEntity));
	    }
		
		return imageDtoList;
	}
	
	// 이름으로 사진 찾기
	public List<ImageResponseDto> search(String keyword){
		List<ImageEntity> imageEntities = imageRepository.findByName(keyword);
		List<ImageResponseDto> imageDtoList = new ArrayList<>();
		
		if (imageEntities.isEmpty()) {
	    	return imageDtoList;
	    }

	    for (ImageEntity imageEntity : imageEntities) {
	        imageDtoList.add(this.convertEntityToDto(imageEntity));
	    }
		return imageDtoList;
	}
	
	private ImageResponseDto convertEntityToDto(ImageEntity imageEntity) {
	    return new ImageResponseDto(imageEntity);
	}
}
