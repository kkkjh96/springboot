package com.academyinfo.claco.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.academyinfo.Class.dto.ClassResponseDto;
import com.academyinfo.Class.service.ClassService;
import com.academyinfo.academy.service.AcademyService;
import com.academyinfo.image.service.ImageService;
import com.academyinfo.review.service.ReviewService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/claco")
@Controller
public class ClacoControllerImpl implements ClacoController{
	
	private AcademyService academyService;
	private ClassService classService;
	private ImageService imageService;
	private ReviewService reviewService;
	
	@GetMapping("/search")
	public String search(@RequestParam(value="keyword", required=false) String keyword, Model model) {
		List<ClassResponseDto> listFilter = classService.search(keyword);
		
		model.addAttribute("listFilter", listFilter);
		
		return "/claco/searchlist";
	}
	
	/*필터 사이트 접근?
	@RequestMapping("/filter")
	public String testFilter(Model model) {
		return "/claco/testSearch";
	}
	*/
	
	/* 필터 적용 다중검색
	@GetMapping("/keyword/search")
	public String testFilter_1(@RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="arr_location_S", required=false) String[] arr_location_S, @RequestParam(value="arr_location_B", required=false) String[] arr_location_B, Model model ) {
		List<ClassResponseDto> listFilter = null;
		
		// 서울체크박스가 선택된 경우 (arr_location_S배열에 값 있을 때)
		if(arr_location_S.length !=0) {
			//서울 지역 SQL문 실행
			listFilter = classService.testFilter_S(keyword, arr_location_S);	
		} else if(arr_location_B.length !=0) {
			// 부산 지역 선택 시 (arr_locations_B 배열에 값 있을 때)
			// 부산 지역 SQL문 실행
			listFilter = classService.testFilter_B(keyword, arr_location_B);
		} else { // 모든 배열에 값이 없을 때
			listFilter = classService.search(keyword);
		}
		
		model.addAttribute("listFilter",listFilter);
		
		return "/claco/testSearchList";
	}
	*/
}