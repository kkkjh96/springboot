package com.jpa05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface JpaController {
	public String listCountries(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
}
