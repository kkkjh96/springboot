package com.academyinfo.board.freeboard.service;

import java.util.List;

import com.academyinfo.board.freeboard.dto.BoardRequestDto;
import com.academyinfo.board.freeboard.dto.BoardResponseDto;

public interface BoardService {
	
	//public List<BoardDto> getBoardlist(Integer pageNum);
	public List<BoardResponseDto> getBoardlist(Integer pageNum);
	
	public BoardResponseDto getPost(int bindex);
	// public BoardDto getPost(int id);
	// public int savePost(BoardRequestDto boardRequestDto);
	public int savePost(String id, BoardRequestDto boardRequestDto);
    public void deletePost(int index);
    
    // public List<BoardDto> searchPosts(String keyword, String filter, Integer pageNum);
    public List<BoardResponseDto> searchPosts(String keyword, String filter, Integer pageNum);
    
    public int getBoardCount(String keyword, String filter);
    public Integer[] getPageList(Integer curPageNum);
	public Integer[] getPageList(Integer curPageNum, String keyword, String filter);
	
	public int getPrev(Integer pageNum, String keyword, String filter);
	public int getNext(Integer pageNum, String keyword, String filter);
	public int updateCount(int no);
}
