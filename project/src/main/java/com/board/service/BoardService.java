package com.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.board.domain.entity.BoardEntity;
import com.board.domain.repository.BoardRepository;
import com.board.dto.BoardDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {
	private BoardRepository boardRepository;

	@Transactional
	public List<BoardDTO> getBoardlist() {
		List<BoardEntity> boardEntities = boardRepository.findAll();
		List<BoardDTO> boardDTOList = new ArrayList<>();

		for (BoardEntity boardEntity : boardEntities) {
			BoardDTO boardDTO = BoardDTO.builder().id(boardEntity.getId()).title(boardEntity.getTitle())
					.content(boardEntity.getContent()).writer(boardEntity.getWriter())
					.createdDate(boardEntity.getCreatedDate()).modifiedDate(boardEntity.getModifiedDate()).build();

			boardDTOList.add(boardDTO);
		}
		return boardDTOList;
	}

	@Transactional
	public BoardDTO getPost(Long id) {
		Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
		BoardEntity boardEntity = boardEntityWrapper.get();

		BoardDTO boardDTO = BoardDTO.builder().id(boardEntity.getId()).title(boardEntity.getTitle())
				.content(boardEntity.getContent()).writer(boardEntity.getWriter())
				.createdDate(boardEntity.getCreatedDate()).build();

		return boardDTO;
	}

	@Transactional
	public Long savePost(BoardDTO boardDTO) {
		return boardRepository.save(boardDTO.toEntity()).getId();
	}

	@Transactional
	public void deletePost(Long id) {
		boardRepository.deleteById(id);
	}

	@Transactional
	public List<BoardDTO> searchPosts(String keyword) {
		List<BoardEntity> boardEntities = boardRepository.findByTitleContaining(keyword);
		List<BoardDTO> boardDTOList = new ArrayList<>();

		if (boardEntities.isEmpty())
			return boardDTOList;

		for (BoardEntity boardEntity : boardEntities) {
			boardDTOList.add(this.convertEntityToDto(boardEntity));
		}

		return boardDTOList;
	}

	private BoardDTO convertEntityToDto(BoardEntity boardEntity) {
		return BoardDTO.builder().id(boardEntity.getId()).title(boardEntity.getTitle())
				.content(boardEntity.getContent()).writer(boardEntity.getWriter())
				.createdDate(boardEntity.getCreatedDate()).build();
	}

	private static final int BLOCK_PAGE_NUM_COUNT = 5; // ���� �����ϴ� ������ ��ȣ ��
	private static final int PAGE_POST_COUNT = 4; // �� �������� �����ϴ� �Խñ� ��

	
	//�˻�
	@Transactional
	public List<BoardDTO> getBoardlist(Integer pageNum) {
		Page<BoardEntity> page = boardRepository
				.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createdDate")));

		List<BoardEntity> boardEntities = page.getContent();
		List<BoardDTO> boardDTOList = new ArrayList<>();

		for (BoardEntity boardEntity : boardEntities) {
			boardDTOList.add(this.convertEntityToDto(boardEntity));
		}

		return boardDTOList;
	}

	@Transactional
	public Long getBoardCount() {
		return boardRepository.count();
	}

	public Integer[] getPageList(Integer curPageNum) {
		Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

		// �� �Խñ� ����
		Double postsTotalCount = Double.valueOf(this.getBoardCount());

		// �� �Խñ� �������� ����� ������ ������ ��ȣ ��� (�ø����� ���)
		Integer totalLastPageNum = (int) (Math.ceil((postsTotalCount / PAGE_POST_COUNT)));

		// ���� �������� �������� ���� ������ ������ ��ȣ ���
		Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
				? curPageNum + BLOCK_PAGE_NUM_COUNT
				: totalLastPageNum;

		// ������ ���� ��ȣ ����
		curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

		// ������ ��ȣ �Ҵ�
		for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
			pageList[idx] = val;
		}

		return pageList;
	}

}
