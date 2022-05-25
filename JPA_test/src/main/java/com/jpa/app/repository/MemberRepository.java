package com.jpa.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.app.domain.MemberEntity;


public interface MemberRepository extends JpaRepository<MemberEntity, String> {
	Page<MemberEntity> findByTitleContaining(String keyword, Pageable pageable);
	
	
}
