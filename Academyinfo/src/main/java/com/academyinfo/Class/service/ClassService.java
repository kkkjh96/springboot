package com.academyinfo.Class.service;

import java.util.List;

import com.academyinfo.Class.dto.ClassResponseDto;

public interface ClassService {
	public List<ClassResponseDto> getClasslist();
	public List<ClassResponseDto> getRecommendClass();
	public List<ClassResponseDto> search(String keyword);
	/*
	public List<ClassResponseDto> testFilter_S(String keyword, String[] arr_location_S);
	public List<ClassResponseDto> testFilter_B(String keyword, String[] arr_location_B);
	*/
}
