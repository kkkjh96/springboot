package com.jpa05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa05.domain.JpaEntity;

public interface JpaTestRepository extends JpaRepository<JpaEntity, Integer> {

}
