package jpa_0509.domain;

import java.sql.Date;

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

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="class")
public class ClassEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_Index;
	
	@Column
	private String c_Name;
	
	@Column
	private String category;
	
	@Column
	private int price;
	
	@Column
	private double score;
	
	@Column
	private String c_Status;
	
	@Column
	private Date s_Period;
	
	@Column
	private Date e_Period;
	
	@Column
	private Integer a_Index;
	
	@Column
	private String a_Name;
	
	@Column
	private String location;
	
	@Column
	private int grade;
	
	@Column
	private Integer i_Index;
	

	
	@Builder
	public ClassEntity(Integer c_Index, String c_Name, String category,
			int price, double score, String c_Status, Date s_Period, 
			Date e_Period, Integer a_Index, String a_Name, String location, 
			int grade, Integer i_Index)
	{
		this.c_Index = c_Index;
		this.c_Name = c_Name;
		this.category = category;
		this.price = price;
		this.score = score;
		this.c_Status = c_Status;
		this.s_Period = s_Period;
		this.e_Period = e_Period;
		this.a_Index = a_Index;
		this.a_Name = a_Name;
		this.location = location;
		this.grade = grade;
		this.i_Index = i_Index;
	}
}
