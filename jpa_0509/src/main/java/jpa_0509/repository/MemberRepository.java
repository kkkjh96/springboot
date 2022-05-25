package jpa_0509.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa_0509.domain.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,Integer>{
	
}
