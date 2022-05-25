package com.sts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sts.domain.stsEntity;
import com.sts.service.stsService;

@Controller("stsController")
public class stsControllerImpl implements stsController {

	@Autowired
	private stsService stsService;

	@Override
	@RequestMapping(value = "/sts/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List membersList = stsService.listMembers();
		ModelAndView mav = new ModelAndView("/member/listMembers");

		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/sts/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("stsEntity") stsEntity stsEntity, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("redirect:/sts/listMembers.do");
		return mav;
	}
}
