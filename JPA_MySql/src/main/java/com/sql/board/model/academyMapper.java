package com.sql.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sql.board.dto.academyDto;
import com.sql.paging.CommonParams;

@Mapper
public interface academyMapper {
	
	/*
	 * �Խñ� �� ��ȸ
	 */
	int count(final CommonParams params);
	
	/*
	 * �Խñ� ����Ʈ ��ȸ
	 */
	List<academyDto> findAll(final CommonParams params);

}
