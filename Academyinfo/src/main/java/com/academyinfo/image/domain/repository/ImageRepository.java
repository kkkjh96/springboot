package com.academyinfo.image.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.academyinfo.image.domain.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity,Integer> {
    List<ImageEntity> findByName(@Param("keyword") String keyword);
}
