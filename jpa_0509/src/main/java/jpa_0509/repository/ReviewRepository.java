package jpa_0509.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jpa_0509.domain.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer>{
	@Query(value = "select * from review order by writedate desc", nativeQuery=true)
	public List<ReviewEntity> selectReview();
}
