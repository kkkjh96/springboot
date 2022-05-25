package com.academyinfo.member.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.academyinfo.member.dto.MemberRequestDto;
import com.academyinfo.member.dto.MemberResponseDto;
import com.academyinfo.member.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberControllerImpl implements MemberController {
    private MemberService memberService;
    
    /*
    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }
    */

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/member/signUp";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberRequestDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }
    
    /*
    // 사업자 회원가입 페이지
    @GetMapping("/user/cpnsignup")
    public String dispCpnSignup() {
        return "/cpnsignup";
    }
	*/
    
    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin(@RequestParam(value = "error", required = false) String error, Model model) {
    	model.addAttribute("error", error);
    	return "/member/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/member/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/member/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 마이페이지
    @GetMapping("/user/mypage")
    public String dispMyInfo(Model model) {
        return "/member/mypage";
        
    }
    
    
    // 회원 정보 수정 페이지(일반,기업 공통)
    @GetMapping("/user/info")
    public String dispUserInfo(Model model) {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // 현재 로그인한 사용자의 정보를 가져온다
		String id = ((UserDetails)principal).getUsername(); // 사용자의 Id
		
		MemberResponseDto memberDto = memberService.getMemberDto(id);
        // String name = memberDto.getName();
        
    	model.addAttribute("memberDto", memberDto);
    	
        return "/member/myinfo";
    }
    
    // 회원 정보 수정하기
    @PutMapping("/user/update")
    public String updateUserInfo(MemberRequestDto memberDto) {
    	memberService.updateUser(memberDto);
    	
    	return "redirect:/user/mypage";
    }
    
    // 일반회원이 찜한 강의 목록 페이지
    @GetMapping("/user/userClassList")
    public String dispUserClassList() {
        return "/member/userClassList";
    }
    
    // 학원이 등록한 강의 목록 페이지
    @GetMapping("/user/cpnClassList")
    public String dispCpnClassList() {
        return "/member/cpnClassList";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/member/admin";
    }
}