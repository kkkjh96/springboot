package com.study.board.entity;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
//엔티티와 레파지토리는 꼭 같은 패키지에 위치!!!
	/*
	 * 게시글 리스트 조회 - (삭제 여부 기준)
	 */
	List<Board> findAllByDeleteYn(final char deleteYn, final Sort sort);
}
