package jpa_0509.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jpa_0509.domain.ClassEntity;


public interface TestController {
	public String listMember(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
	public String testMain(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception;
	public String testFilter(Model model) throws Exception;
	public String testFilter_1(@RequestParam(value="keyword") String keyword, Model model) throws Exception;
	public String testFilter_2(@RequestParam(value="searchType") String searchType, Model model) throws Exception;
	public String testFilter_3(@RequestParam(value="searchWord") String searchType, Model model) throws Exception;
	
}
