package com.jpa05.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa05.service.JpaService;

@Controller("JpaController")
public class JpaControllerImpl implements JpaController {

	@Autowired
	private JpaService jpaService;

	@ResponseBody
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello JPA!!");
		return "Hello JPA!!";
	}

	@RequestMapping("/hello.do")
	public String hello(Model model) {
		System.out.println("안녕하세요 JPA");
		model.addAttribute("message", "jpa입니다.!");
		return "hello";
	}

	@Override
	@RequestMapping("/listcountries.do")
	public String listCountries(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		List  listCountries = jpaService.listCountries();
		model.addAttribute("listCountries", listCountries);
		return "listCountries";
	}

}
