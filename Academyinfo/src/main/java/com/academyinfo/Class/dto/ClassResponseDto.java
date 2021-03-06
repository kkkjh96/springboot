package com.academyinfo.Class.dto;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.academyinfo.Class.domain.entity.ClassEntity;
import com.academyinfo.member_class.domain.entity.MemberClassEntity;
import com.academyinfo.member_class.dto.MemberClassResponseDto;
import com.academyinfo.review.domain.entity.ReviewEntity;
import com.academyinfo.review.dto.ReviewResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ClassResponseDto {
	private Integer cindex;
	private String name;
	private String category;
	private int price;
	private double score;
	private String status;
	private Date startperiod;
	private Date endperiod;
	private String info;
	private Integer iindex;
	
	// academy 테이블과의 조인 설정
	// private Integer aindex;
	private String aname;
	private int agrade;
	private String alocation;
	
	// review 테이블과의 조인 설정
	private List<ReviewResponseDto> reviews;
	
	// member_class 테이블과의 조인 설정
	private List<MemberClassResponseDto> mcindex;
	
	@Builder
	public ClassResponseDto(Integer cindex, String name, String category, int price, double score, String status, Date startperiod, Date endperiod, String info, String location,  int iindex, String aname, int agrade, String alocation, List<ReviewEntity> rvindex, List<MemberClassEntity> mcindex) {
		this.cindex = cindex;
		this.name = name;
		this.category = category;
		this.price = price;
		this.score = score;
		this.status = status;
		this.startperiod = startperiod;
		this.endperiod = endperiod;
		this.info = info;
		this.iindex = iindex;
		this.aname = aname;
		this.alocation = alocation;
		this.agrade = agrade;
		
		// 리뷰 List 타입을 DTO 클래스로 하여 엔티티 간 무한참조 방지
		this.reviews = rvindex.stream().map(ReviewResponseDto::new).collect(Collectors.toList());
		
		this.mcindex = mcindex.stream().map(MemberClassResponseDto::new).collect(Collectors.toList());;
	}
	
	@Builder
	public ClassResponseDto(ClassEntity classEntity) {
		this.cindex = classEntity.getCindex();
		this.name = classEntity.getName();
		this.category = classEntity.getCategory();
		this.price = classEntity.getPrice();
		this.score = classEntity.getScore();
		this.status = classEntity.getStatus();
		this.startperiod = classEntity.getStartperiod();
		this.endperiod = classEntity.getEndperiod();
		this.info = classEntity.getInfo();
		this.iindex = classEntity.getIindex();
		this.aname = classEntity.getAindex().getName();
		this.alocation = classEntity.getAindex().getLocation();
		this.agrade = classEntity.getAindex().getGrade();
		
		// 리뷰 List 타입을 DTO 클래스로 하여 엔티티 간 무한참조 방지
		this.reviews = classEntity.getRvindex().stream().map(ReviewResponseDto::new).collect(Collectors.toList());
		
		this.mcindex = classEntity.getMcindex().stream().map(MemberClassResponseDto::new).collect(Collectors.toList());;
	}
}
