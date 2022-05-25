package com.academyinfo.review.domain.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.academyinfo.review.domain.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer>{
	
	List<ReviewEntity> findAll(Sort sort);
}
