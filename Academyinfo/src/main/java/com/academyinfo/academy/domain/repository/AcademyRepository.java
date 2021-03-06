package com.academyinfo.academy.domain.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.academyinfo.academy.domain.entity.AcademyEntity;


@Repository
public interface AcademyRepository extends JpaRepository<AcademyEntity, Integer> {
	
	Optional<AcademyEntity> findByMindex(Long mindex);
	

	

}
