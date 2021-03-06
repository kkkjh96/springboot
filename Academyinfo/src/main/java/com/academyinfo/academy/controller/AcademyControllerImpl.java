package com.academyinfo.academy.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academyinfo.academy.dto.AcademyRequestDto;
import com.academyinfo.academy.dto.AcademyResponseDto;
import com.academyinfo.academy.service.AcademyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/academy")
@Controller
public class AcademyControllerImpl implements AcademyController {
	private AcademyService academyService;
	
	@GetMapping("")
	public String list(Model model) {
		List<AcademyResponseDto> academyList = academyService.findAll();
		
		model.addAttribute("academyList", academyList);
		
		return "form/list";
	}
	
	@PostMapping("/post")
	public String academyWrite(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String mid = ((UserDetails)principal).getUsername();
		
		model.addAttribute("mid", mid);
		
		return "form/addForm";
	}
	
	@PostMapping("/posts")
	public String academyWrite(AcademyRequestDto academyDto) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String mid = ((UserDetails)principal).getUsername();
		
		academyService.saveAcademyInfo(mid, academyDto);
		
		return "redirect:/academy";
	}
	
	
	
	
}
