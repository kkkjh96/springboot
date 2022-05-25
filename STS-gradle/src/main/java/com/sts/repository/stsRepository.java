package com.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.domain.stsEntity;

public interface stsRepository extends JpaRepository<stsEntity, String> {

}
