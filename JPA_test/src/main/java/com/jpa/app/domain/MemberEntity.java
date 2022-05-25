package com.jpa.app.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MEMBER")

public class MemberEntity implements Serializable {
	 
	@Id
	@Column(name = "ID")
	private String id;
	@Column(name = "PWD")
	private String pwd;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "JOINDATE")
	private Date joinDate;

	public MemberEntity() {
		System.out.println("MemberEntity ╦егн");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
