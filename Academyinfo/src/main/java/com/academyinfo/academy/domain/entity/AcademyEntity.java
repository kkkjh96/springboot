package com.academyinfo.academy.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.academyinfo.Class.domain.entity.ClassEntity;
import com.academyinfo.member.domain.entity.MemberEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="academy")
public class AcademyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aindex;
	
	@Column
	private String name;
	
	@Column
	private int grade;
	
	@Column
	private String location;
	
	@Column
	private String address;
	
	@Column
	private String companynum;
	
	@Column
	private String info;
	
	@OneToOne
	@JoinColumn(name = "mindex")
	private MemberEntity mindex;
	
	@Column
	@OneToMany(mappedBy = "aindex", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ClassEntity> cindex;
	
	@Builder
	public AcademyEntity (Integer aindex, String name, int grade, String location, String address, String companynum, String info, MemberEntity mindex, List<ClassEntity> cindex) {
		this.aindex = aindex;
		this.name = name;
		this.grade = grade;
		this.location = location;
		this.address = address;
		this.companynum = companynum;
		this.info = info;
		this.mindex = mindex;
		this.cindex = cindex;
	}
}
