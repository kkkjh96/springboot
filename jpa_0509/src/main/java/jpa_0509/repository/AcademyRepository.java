package jpa_0509.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa_0509.domain.AcademyEntity;

public interface AcademyRepository  extends JpaRepository<AcademyEntity, Integer>{

	@Query(value = "select * from academy where address LIKE %:searchType%", nativeQuery = true)
	List<AcademyEntity> findByAddress(@Param("searchType") String searchType);
	
	@Query(value = "select * from academy where location LIKE %:searchWord%", nativeQuery = true)
	List<AcademyEntity> findByLocation(@Param("searchWord") String searchWord);
}
