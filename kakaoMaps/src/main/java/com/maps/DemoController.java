package com.maps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	//@ResponseBody
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello Boot!!");
		return "kakaomap!!";
	}

//	@RequestMapping("/hello.do")
//	public String hello(Model model) {
//		System.out.println("�ȳ��ϼ���");
//		model.addAttribute("message", "hello.jsp�Դϴ�.!");
//		return "hello";
//	}
	
	@RequestMapping("/kakao.do")
	public String kakao(Model model) {
		System.out.println("�ȳ��ϼ���");
		model.addAttribute("message", "īī�� ���� �Դϴ�.!");
		return "kakaomap";
	}
}
