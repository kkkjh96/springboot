package com.sql.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="academy")
public class academy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer a_index;
	@Column
	private String id;
	@Column
	private String pwd;
	@Column
	private String a_name;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String company_num;
	@Column
	private String address;
	@Column
	private String location;
	@Column
	private Integer grade;
	@Column
	private Integer totalscore;
	@Column
	private Integer reviewcount;
	
	@Builder
	public academy(Integer a_index, String id, String pwd, String a_name, String phone, String email, 
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
