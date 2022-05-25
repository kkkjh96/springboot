package jpa_0509.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa_0509.domain.ImgEntity;

public interface ImgRepository extends JpaRepository<ImgEntity,Integer> {
	@Query("SELECT u FROM ImgEntity u WHERE u.name = :name")
    List<ImgEntity> findByName(@Param("name")String name);
}
