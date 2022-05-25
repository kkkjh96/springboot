package com.academyinfo.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academyinfo.common.entity.Role;
import com.academyinfo.member.domain.entity.MemberEntity;
import com.academyinfo.member.domain.repository.MemberRepository;
import com.academyinfo.member.dto.MemberRequestDto;
import com.academyinfo.member.dto.MemberResponseDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    // 회원가입 로직
    @Transactional
    public Long joinUser(MemberRequestDto memberDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPwd(passwordEncoder.encode(memberDto.getPwd()));

        return memberRepository.save(memberDto.toEntity()).getMindex();
    }
    
    // 회원수정 로직
    @Transactional
    public Long updateUser(MemberRequestDto memberDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPwd(passwordEncoder.encode(memberDto.getPwd()));
        
        return memberRepository.save(memberDto.toEntity()).getMindex();
    }
    
    // 로그인 로직
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findById(id);
        MemberEntity userEntity = userEntityWrapper.get();
        String role = userEntity.getRole();

        List<GrantedAuthority> authorities = new ArrayList<>();		// 권한 인스턴스 생성
        
        // 회원가입 할때 추가된 권한 테이블을 조회하여 각각의 조건에 맞게 권한 부여
        if (("admin").equals(id)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else if (("ROLE_MEMBER").equals(role)) {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        } else if (("ROLE_COMPANY").equals(role)) {
        	authorities.add(new SimpleGrantedAuthority(Role.COMPANY.getValue()));
        }

        return new User(userEntity.getId(), userEntity.getPwd(), authorities);
    }
    
    // 회원정보 조회 로직
    @Transactional(readOnly=true)
    public MemberResponseDto getMemberDto(String id) {
    	Optional<MemberEntity> userEntityWrapper = memberRepository.findById(id);
        MemberEntity userEntity = userEntityWrapper.get();
        
    	return this.convertEntityToDto(userEntity);
    }
    
    private MemberResponseDto convertEntityToDto(MemberEntity memberEntity) {
	    return new MemberResponseDto(memberEntity);
	}
}