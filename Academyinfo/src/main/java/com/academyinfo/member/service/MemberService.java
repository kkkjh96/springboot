package com.academyinfo.member.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.academyinfo.member.dto.MemberRequestDto;
import com.academyinfo.member.dto.MemberResponseDto;

public interface MemberService extends UserDetailsService {

    // 회원가입 로직
    public Long joinUser(MemberRequestDto memberDto);
    
    // 회원수정 로직
    public Long updateUser(MemberRequestDto memberDto);
    
    // 로그인 로직
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException;
    
    // 회원정보 조회 로직
    public MemberResponseDto getMemberDto(String id);

}
