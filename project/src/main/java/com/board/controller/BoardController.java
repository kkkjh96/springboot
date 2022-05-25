package com.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	private BoardService boardService;
	
	/* �Խñ� ��� */
	@GetMapping("/")
	public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
	List<BoardDTO> boardList = boardService.getBoardlist(pageNum);
	Integer[] pageList = boardService.getPageList(pageNum);

	model.addAttribute("boardList", boardList);
	model.addAttribute("pageList", pageList);

	return "board/list.html";
	}

	@GetMapping("/post")
	public String write() {
		return "board/write.html";
	}
	
	@PostMapping("/post")
	public String write(BoardDTO boardDTO) {
		boardService.savePost(boardDTO);
		
		return "redirect:/";
	}
	
	@GetMapping("/post/{no}")
	public String detail(@PathVariable("no") Long no, Model model) {
		BoardDTO boardDTO = boardService.getPost(no);
		
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail.html";
	}
	
	@GetMapping("/post/edit/{no}")
	public String edti(@PathVariable("no") Long no, Model model) {
		BoardDTO boardDTO = boardService.getPost(no);
		
		model.addAttribute("boardDTO", boardDTO);
		return "board/update.html";
	}
	
	@PutMapping("/post/edit/{no}")
	public String update(BoardDTO boardDTO) {
		boardService.savePost(boardDTO);
		
		return "redirect:/";
	}
	
	@DeleteMapping("/post/{no}")
	public String delete(@PathVariable("no") Long no) {
		boardService.deletePost(no);
		
		return "redirect:/";
	}
	
	@GetMapping("/board/search")
	public String search(@RequestParam(value="keyword") String keyword, Model model) {
		List<BoardDTO> boardDTOList = boardService.searchPosts(keyword);
		
		model.addAttribute("boardList", boardDTOList);
		
		return "board/list.html";
	}

}
