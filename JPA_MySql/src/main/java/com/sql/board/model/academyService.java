package com.sql.board.model;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sql.board.dto.academyDto;
import com.sql.board.entity.academy;
import com.sql.board.entity.academyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class academyService {

	private academyRepository academyRepository;
	
	@Transactional
	public List<academyDto> getacademylist(){
		List<academy> academyEntities = academyRepository.findAll();
		List<academyDto> academyDtoList = new ArrayList<>();
		
		for(academy academyEntity : academyEntities) {
			academyDto academyDto = com.sql.board.dto.academyDto.builder()
					.a_index(academyEntity.getA_index())
					.id(academyEntity.getId())
					.pwd(academyEntity.getPwd())
					.a_name(academyEntity.getA_name())
					.phone(academyEntity.getPhone())
					.email(academyEntity.getEmail())
					.company_num(academyEntity.getCompany_num())
					.address(academyEntity.getAddress())
					.location(academyEntity.getLocation())
					.grade(academyEntity.getGrade())
					.totalscore(academyEntity.getTotalscore())
					.reviewcount(academyEntity.getTotalscore())
					.build();
			
			academyDtoList.add(academyDto);
		}
		return academyDtoList;
	}
	
//	@Transactional
//	public List<academyDto> searchPosts(String keyword){
//		List<academy> academys = academyRepository.findByTitleContaining(keyword);
//		List<academyDto> academyDtoList = new ArrayList<>();
//		
//		if(academys.isEmpty()) return academyDtoList;
//		
//		for(academy academy : academys) {
//			academyDtoList.add(this.locationEntityToDto(academy));
//		}
//		return academyDtoList;
//	}

	
}
