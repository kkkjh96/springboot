package jpa_0509.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "academy")
@Data
public class AcademyEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer a_Index;
	@Column
	private String id;
	@Column
	private String pwd;
	@Column
	private String a_name1;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String company_Num;
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
	

	
//	public AcademyEntity(String address){
//		this.address = address;
//	}
		
	@Builder
	public AcademyEntity(Integer a_Index, String id, String pwd, String a_name1, String phone, String email, 
			String company_Num, String address, String location,
			Integer grade, Integer totalscore, Integer reviewcount) {
		this.a_Index = a_Index;
		this.id = id;
		this.pwd = pwd;
		this.a_name1 = a_name1;
		this.phone = phone;
		this.email = email;
		this.company_Num = company_Num;
		this.address = address;
		this.location = location;
		this.grade = grade;
		this.totalscore = totalscore;
		this.reviewcount = reviewcount;
	}
	

	

}
