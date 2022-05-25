package com.jpa.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpa.app.domain.MemberEntity;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView addMember(@ModelAttribute("info") MemberEntity memberEntity, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView removeMember(@RequestParam("id") MemberEntity member, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView login(@ModelAttribute("member") MemberEntity memberEntity, RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
