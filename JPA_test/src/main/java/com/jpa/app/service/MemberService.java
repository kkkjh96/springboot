package com.jpa.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jpa.app.domain.MemberEntity;

public interface MemberService {
	public List listMembers() throws Exception;

	public void addMember(MemberEntity memberEntity) throws Exception;

	public void removeMember(MemberEntity member) throws Exception;

	public MemberEntity login(MemberEntity memberEntity) throws Exception;

//	public Page<MemberEntity> postMembers(String keyword, Pageable pageable);
}
