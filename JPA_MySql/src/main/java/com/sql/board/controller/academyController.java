package com.sql.board.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sql.board.dto.academyDto;
import com.sql.board.model.academyService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class academyController {

	private academyService academyService;
	
	@GetMapping("/board/list")
	public String list(Model model) {
		List<academyDto> academyList = academyService.getacademylist();
		
		model.addAttribute("academyList", academyList);
		return "board/list.html";
	}
	

	
//	@GetMapping("/board/search")
//	public String search(@RequestParam(value = "keyword") String keyword, Model model) {
//		List<academyDto> academyDtoList = academyService.searchPosts(keyword);
//		model.addAttribute("academyList", academyDtoList);
//		
//		return "board/list.html";
//	}
}
