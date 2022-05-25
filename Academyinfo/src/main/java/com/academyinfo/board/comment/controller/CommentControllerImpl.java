package com.academyinfo.board.comment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academyinfo.board.comment.dto.CommentRequestDto;
import com.academyinfo.board.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/freeboard")
@RestController
public class CommentControllerImpl implements CommentController {
	private final CommentService commentService;
	
	// 댓글 생성
	@PostMapping("/post/{no}/comments")
	public ResponseEntity commentSave(@PathVariable("no") int no, @RequestBody CommentRequestDto dto) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // 현재 로그인한 사용자의 정보를 가져온다
		String id = ((UserDetails)principal).getUsername(); // 사용자의 Id
		
		return ResponseEntity.ok(commentService.commentSave(id, no, dto));
	}
	
	// 댓글 수정
	@PutMapping({"/post/{no}/comments/{no2}"})
	public ResponseEntity update(@PathVariable("no") int no, @PathVariable("no2") int no2, @RequestBody CommentRequestDto dto) {
		commentService.update(no2, dto);
		
		return ResponseEntity.ok(no);
	}
	
	// 댓글 삭제 (no : board.index 유지 / no2 : comment.index 조회 및 삭제)
	@DeleteMapping("/post/{no}/comments/{no2}")
	public ResponseEntity delete(@PathVariable("no") int no, @PathVariable("no2") int no2) {
		commentService.delete(no2);
		
		return ResponseEntity.ok(no);
	}
}
