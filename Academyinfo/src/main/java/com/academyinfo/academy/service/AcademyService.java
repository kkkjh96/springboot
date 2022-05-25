package com.academyinfo.academy.service;

import java.util.List;

import com.academyinfo.academy.dto.AcademyRequestDto;
import com.academyinfo.academy.dto.AcademyResponseDto;




public interface AcademyService {

	public List<AcademyResponseDto> findAll();
	
	public int saveAcademyInfo(String mid, AcademyRequestDto academyDto);

	
	

}
