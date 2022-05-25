package com.academyinfo.common.index.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.academyinfo.Class.dto.ClassResponseDto;
import com.academyinfo.Class.service.ClassService;
import com.academyinfo.board.alertboard.dto.AlertBoardResponseDto;
import com.academyinfo.board.alertboard.service.AlertBoardService;
import com.academyinfo.board.freeboard.dto.BoardResponseDto;
import com.academyinfo.board.freeboard.service.BoardService;
import com.academyinfo.image.dto.ImageResponseDto;
import com.academyinfo.image.service.ImageService;
import com.academyinfo.review.dto.ReviewResponseDto;
import com.academyinfo.review.service.ReviewService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {
	private static final int PAGE_NUM = 1;
	
	private BoardService freeBoardService;
	private AlertBoardService alertBoardService;
	private ImageService imageService;
	private ClassService classService;
	private ReviewService reviewService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		// 게시판 리스트
		List<BoardResponseDto> freeboardList = freeBoardService.getBoardlist(PAGE_NUM);
		List<AlertBoardResponseDto> alertboardList = alertBoardService.getBoardlist(PAGE_NUM);
		
		/*추천강좌카드*/
		List<ImageResponseDto> listImg = imageService.getImage();
		List<ClassResponseDto> listClass = classService.getRecommendClass();
		
		/*수강후기*/
		List<ReviewResponseDto> listReview = reviewService.getReview();
		
		// 게시판 리스트
		model.addAttribute("freeboardList", freeboardList);
		model.addAttribute("alertboardList", alertboardList);
		
		/*추천강좌카드*/
		model.addAttribute("listImg", listImg);
		model.addAttribute("listClass", listClass);
		
		/*수강후기*/
		model.addAttribute("listReview", listReview);
		
        return "/index";
    }
}
