package com.sql.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sql.board.dto.academyDto;
import com.sql.paging.CommonParams;

@Mapper
public interface academyMapper {
	
	/*
	 * 게시글 수 조회
	 */
	int count(final CommonParams params);
	
	/*
	 * 게시글 리스트 조회
	 */
	List<academyDto> findAll(final CommonParams params);

}
