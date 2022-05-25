package com.arduino.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arduino.service.ArduinoService;

@Controller("ArduinoController")
public class ArduinoControllerImpl implements ArduinoController {

	@Autowired
	private ArduinoService arduinoService;

	@Override
	@RequestMapping("/listarduino.do")
	public String listArduino(HttpServletRequest request, HttpServletResponse reponse, Model model) 
			throws Exception {
		List listArduino = arduinoService.listArduino();
		model.addAttribute("listArduino", listArduino);
		return "listArduino";
	}

}
