package com.sql.board.dto;

import com.sql.board.entity.academy;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class academyDto {
	private Integer a_index;
	
	private String id;
	
	private String pwd;
	
	private String a_name;
	
	private String phone;
	
	private String email;
	
	private String company_num;
	
	private String address;
	
	private String location;
	
	private Integer grade;
	
	private Integer totalscore;
	
	private Integer reviewcount;
	
	public academy toEntity() {
		academy academyEntity = academy.builder()
				.a_index(a_index)
				.id(id)
				.pwd(pwd)
				.a_name(a_name)
				.phone(phone)
				.email(email)
				.company_num(company_num)
				.address(address)
				.location(location)
				.grade(grade)
				.totalscore(totalscore)
				.reviewcount(reviewcount)
				.build();
			return academyEntity;
	}
	

	@Builder
	public academyDto(Integer a_index, String id, String pwd, String a_name, String phone, String email, 
			String company_num, String address, String location,
			Integer grade, Integer totalscore, Integer reviewcount) {
		this.a_index = a_index;
		this.id = id;
		this.pwd = pwd;
		this.a_name = a_name;
		this.phone = phone;
		this.email = email;
		this.company_num = company_num;
		this.address = address;
		this.location = location;
		this.grade = grade;
		this.totalscore = totalscore;
		this.reviewcount = reviewcount;
	}
}	


