package com.academyinfo.board.comment.service;

import com.academyinfo.board.comment.dto.CommentRequestDto;

public interface CommentService {
	public int commentSave(String id, int bindex, CommentRequestDto dto);
	
	public void update(int bindex, CommentRequestDto dto);
	
	public void delete(int bindex);
}
