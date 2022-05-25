package jpa_0509.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="member")
public class MemberEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer m_Index;
	
	@Column
	private String id;
	
	@Column
	private String pwd;
	
	@Column
	private String m_Name;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column
	private Date join_Date;
	
	@Column
	private Integer book_Mark;
	
	@Builder
	public MemberEntity(Integer m_Index, String id, String pwd, String m_Name, String phone, 
			String email, Date join_Date, Integer book_Mark) {
		this.m_Index = m_Index;
		this.id = id;
		this.pwd = pwd;
		this.m_Name = m_Name;
		this.phone = phone;
		this.email = email;
		this.join_Date = join_Date;
		this.book_Mark = book_Mark;
	}

	
}
