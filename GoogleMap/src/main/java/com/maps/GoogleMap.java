package com.maps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleMap {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Hello GoogleMap!!!");
		return "GoogleMap!!!";
	}
	
	@RequestMapping("/googlemap.do")
	public String google(Model model) {
		System.out.println("Google Map!!!");
		model.addAttribute("message", "구글 지도 입니다!!!");
		return "googlemap";
	}
}
