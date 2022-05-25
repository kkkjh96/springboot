package com.sts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


import com.sts.domain.stsEntity;

public interface stsController {

	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView addMember(@ModelAttribute("info") stsEntity stsEntity, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
