package com.arduino.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface ArduinoController {

	public String listArduino(HttpServletRequest request, HttpServletResponse reponse, Model model) 
			throws Exception;
}
