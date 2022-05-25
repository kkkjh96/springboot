package jpa_0509.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa_0509.domain.ClassEntity;
import jpa_0509.domain.ImgEntity;

public interface ClassRepository extends JpaRepository<ClassEntity,Integer>{
	@Query(value = "select * from (select *, rank() over(order by score desc) as 'ranking' from class where c_Status IN('approval')) as t where  t.ranking<=4 limit 4", nativeQuery = true)
	public List<ClassEntity> selectRecommendedCourse();
	
	@Query(value = "SELECT * FROM class WHERE c_Status IN('approval') && c_Name LIKE %:keyword%", nativeQuery = true)
	List<ClassEntity> findByKeyword(@Param("keyword") String keyword);
	

}
