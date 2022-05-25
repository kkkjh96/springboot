package com.academyinfo.board.comment.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.academyinfo.board.comment.domain.entity.CommentEntity;
import com.academyinfo.board.comment.domain.repository.CommentRepository;
import com.academyinfo.board.comment.dto.CommentRequestDto;
import com.academyinfo.board.freeboard.domain.entity.BoardEntity;
import com.academyinfo.board.freeboard.domain.repository.BoardRepository;
import com.academyinfo.member.domain.entity.MemberEntity;
import com.academyinfo.member.domain.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commentRepository;
	private final MemberRepository memberRepository;
	private final BoardRepository boardRepository;
	
	// 댓글 생성
	@Transactional
	public int commentSave(String id, int bindex, CommentRequestDto dto) {
		Optional<MemberEntity> memberEntityWrapper = memberRepository.findById(id);
        MemberEntity member = memberEntityWrapper.get();
        
		BoardEntity board = boardRepository.findById(bindex).orElseThrow(() ->
		new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + bindex));
		
		dto.setBindex(board);
		dto.setMindex(member);
		CommentEntity comment = dto.toEntity();
		commentRepository.save(comment);
		
		return dto.getCmtindex();
	}
	
	// 댓글 수정
	@Transactional
	public void update(int cmtindex, CommentRequestDto dto) {
		CommentEntity comment = commentRepository.findById(cmtindex).orElseThrow(() ->
		new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + cmtindex));
		
		comment.update(dto.getComment());
	}
	
	// 댓글 삭제
	@Transactional
	public void delete(int cmtindex) {
		CommentEntity comment = commentRepository.findById(cmtindex).orElseThrow(() ->
		new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + cmtindex));
		
		commentRepository.delete(comment);
	}
}
