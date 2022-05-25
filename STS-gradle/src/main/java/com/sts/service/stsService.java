package com.sts.service;

import java.util.List;

import com.sts.domain.stsEntity;

public interface stsService {

	public List listMembers() throws Exception;
	
	public void addMember(stsEntity stsEntity) throws Exception;
}
