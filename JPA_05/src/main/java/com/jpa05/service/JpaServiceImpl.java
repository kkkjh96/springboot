package com.jpa05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa05.repository.JpaTestRepository;

@Service("JpaService")
@Transactional
public class JpaServiceImpl implements JpaService {
	
	@Autowired
	private JpaTestRepository jpaTestRepository;
	
	@Override
	public List listCountries() {
		return jpaTestRepository.findAll();
	}
}
