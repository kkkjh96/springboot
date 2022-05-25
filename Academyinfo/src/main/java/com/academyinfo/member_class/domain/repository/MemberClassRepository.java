package com.academyinfo.member_class.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academyinfo.member_class.domain.entity.MemberClassEntity;

public interface MemberClassRepository extends JpaRepository<MemberClassEntity, Integer> {

}
