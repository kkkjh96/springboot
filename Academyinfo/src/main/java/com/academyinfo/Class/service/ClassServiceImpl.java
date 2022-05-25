package com.academyinfo.Class.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academyinfo.Class.domain.entity.ClassEntity;
import com.academyinfo.Class.domain.repository.ClassRepository;
import com.academyinfo.Class.dto.ClassResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClassServiceImpl implements ClassService {
	private ClassRepository classRepository;
	
	private static final int RECOMMAND_INT = 4;
	
	//select * from class;
	@Transactional(readOnly = true)
	public List<ClassResponseDto> getClasslist(){
		List<ClassEntity> classEntities = classRepository.findAll();
		List<ClassResponseDto> classDtoList = new ArrayList<>();
		
		if (classEntities.isEmpty()) {
			return classDtoList;
		}
		
		for (ClassEntity classEntity : classEntities) {
			classDtoList.add(this.convertEntityToDto(classEntity));
		}
		
		return classDtoList;
	}
	
	/*추천강의(c_status가 approval이면서 점수가 제일 높은 4개의 강의를 최근등록순) - 강의내용*/
	
	@Transactional(readOnly = true)
	public List<ClassResponseDto> getRecommendClass(){
		Sort sort = Sort.by(
				Sort.Order.desc("score"),
				Sort.Order.desc("cindex")
				);
		String status = "approval";
		
		List<ClassEntity> classEntities = classRepository.findByStatus(status, sort);
		List<ClassResponseDto> recommandClassList = new ArrayList<>();
		
		if (classEntities.isEmpty()) {
			return recommandClassList;
		}
		
		for(int i=0; i < RECOMMAND_INT; i++) {
			recommandClassList.add(this.convertEntityToDto(classEntities.get(i)));
		}
		
		return recommandClassList;
	}
	
	/* 키워드 검색 */
	@Transactional(readOnly = true)
	public List<ClassResponseDto> search(String keyword){
		List<ClassEntity> classEntities = classRepository.findByNameContaining(keyword);
		List<ClassResponseDto> classDtoList = new ArrayList<>();
		
		if (classEntities.isEmpty()) {
			return classDtoList;
		}
		
		for (ClassEntity classEntity : classEntities) {
			classDtoList.add(this.convertEntityToDto(classEntity));
		}
		
		return classDtoList;
	}
	
	/*키워드와 서울지역 검색
	public List<ClassResponseDto> testFilter_S(String keyword, String[] arr_location_S){
		List<ClassEntity> classEntities = classRepository.testFilter_S(keyword, arr_location_S);		
		List<ClassResponseDto> classDtoList = new ArrayList<>();
		
		if (classEntities.isEmpty()) {
			return classDtoList;
		}
		
		for (ClassEntity classEntity : classEntities) {
			classDtoList.add(this.convertEntityToDto(classEntity));
		}
		
		return classDtoList;
	}
	*/
	/*키워드와 부산지역 검색
	public List<ClassResponseDto> testFilter_B(String keyword, String[] arr_location_B) {
		List<ClassEntity> classEntities = classRepository.testFilter_B(keyword, arr_location_B);
		List<ClassResponseDto> classDtoList = new ArrayList<>();
		
		if (classEntities.isEmpty()) {
			return classDtoList;
		}
		
		for (ClassEntity classEntity : classEntities) {
			classDtoList.add(this.convertEntityToDto(classEntity));
		}
		
		return classDtoList;
	}
	*/
	
	private ClassResponseDto convertEntityToDto(ClassEntity classEntity) {
		ClassResponseDto classResponseDto = new ClassResponseDto(classEntity);
		
		return classResponseDto;
	}
}
