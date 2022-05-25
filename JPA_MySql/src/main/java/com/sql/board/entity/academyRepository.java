package com.sql.board.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface academyRepository extends JpaRepository<academy, String> {

//	List<academy> findByTitleContaining(String keyword);

}
