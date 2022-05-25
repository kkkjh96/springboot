package jpa_0509.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jpa_0509.domain.ClassEntity;
import jpa_0509.service.TestService;



@Controller("MemberController")
public class TestControllerImpl implements TestController{
	@Autowired
	private TestService testService;
	
	@Override
	@RequestMapping("/detailInfo.do")
	public String listMember(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception
	{
		return "detailInfo";
	}
	
	//메인 페이지
	@Override
	@RequestMapping("/Main")
	public String testMain(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception
	{
		/*��õ����ī��*/
		List listImg = testService.listImg();
		List listClass = testService.selectRecommendedCourse();
		/*�����ı�*/
		List listReview = testService.selectReview();
		
		/*��õ����ī��*/
		model.addAttribute("listImg", listImg);
		model.addAttribute("listClass",listClass);
		/*�����ı�*/
		model.addAttribute("listReview",listReview);
		
		return "testMain";
	}
	
	/*����*/
	@Override
	@RequestMapping("/Filter")
	public String testFilter(Model model) throws Exception
	{
		return "testSearch";
	}
	
	/*���� �� �˻��� ����Ʈ*/
	@Override
	@GetMapping("/keyword/search")
	public String testFilter_1(@RequestParam(value="keyword") String keyword, Model model) throws Exception
	{
		List listKeyword = testService.findByKeyword(keyword);
		model.addAttribute("listKeyword",listKeyword);
		return "testSearchList";
	}
	
	@GetMapping("/keyword/search2")
	public String testFilter_2(@RequestParam(value="searchType") String searchType, Model model) throws Exception
	{
		List listSearchType = testService.findByAddress(searchType);
		model.addAttribute("listSearchType", listSearchType);
		return "testSearchList";
	}

	@GetMapping("/search/check")
	public String testFilter_3(@RequestParam(value="searchWord") String searchWord, Model model) throws Exception
	{
		List listSearchWord = testService.findByLocation(searchWord);
		model.addAttribute("listSearchWord", listSearchWord);
		return "testSearchList";
	}
	

	
}