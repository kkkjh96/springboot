package com.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sts.domain.stsEntity;
import com.sts.repository.stsRepository;

@Service("stsService")
@Transactional
public class stsServiceImpl implements stsService {

	@Autowired
	private stsRepository stsRepository;
	
	@Override
	public List listMembers() throws Exception {
		return stsRepository.findAll();
	}
	
	@Override
	public void addMember(stsEntity stsEntity) throws Exception{
		stsRepository.save(stsEntity);
	}
	
	
}
