package com.academyinfo.academy.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academyinfo.academy.domain.entity.AcademyEntity;
import com.academyinfo.academy.domain.repository.AcademyRepository;
import com.academyinfo.academy.dto.AcademyRequestDto;
import com.academyinfo.academy.dto.AcademyResponseDto;
import com.academyinfo.member.domain.entity.MemberEntity;
import com.academyinfo.member.domain.repository.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AcademyServiceImpl implements AcademyService {
	private AcademyRepository academyRepository;
	private MemberRepository memberRepository;
	
	public List<AcademyResponseDto> findAll(){
		Sort sort = Sort.by(Direction.DESC, "aindex");
		List<AcademyEntity> list = academyRepository.findAll(sort);
		
		return list.stream().map(AcademyResponseDto::new).collect(Collectors.toList());
	}
	
	@Transactional
	public int saveAcademyInfo(String mid, AcademyRequestDto academyDto) {
		Optional<MemberEntity> memberEntityWrapper = memberRepository.findById(mid);
		MemberEntity member = memberEntityWrapper.get();
		academyDto.setMindex(member);
		
		return academyRepository.save(academyDto.toEntity()).getAindex();
	}

}