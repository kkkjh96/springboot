package com.academyinfo.board.freeboard.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.academyinfo.board.comment.dto.CommentResponseDto;
import com.academyinfo.board.freeboard.dto.BoardRequestDto;
import com.academyinfo.board.freeboard.dto.BoardResponseDto;
import com.academyinfo.board.freeboard.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/freeboard")
@AllArgsConstructor
public class BoardControllerImpl implements BoardController {
private BoardService boardService;
	
	// 게시글 목록 출력
	// Model 객체를 통해 View에 데이터 전달
	@GetMapping("")
	public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
		// page 이름으로 넘어오면 파라미터를 받고, 없으면 기본값 1 설정
			
		List<BoardResponseDto> boardList = boardService.getBoardlist(pageNum);
		Integer[] pageList = boardService.getPageList(pageNum);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageList", pageList);
		model.addAttribute("currentPage", pageNum); // 현재 페이지에 특수효과 주기 위한 attribute
		
		addPrevNext(pageList, pageNum, model);
		
		return "/freeboard/list";
	}
	
	// 게시글 등록화면으로 이동
	@GetMapping("/post")
	public String write(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // 현재 로그인한 사용자의 정보를 가져온다
		String id = ((UserDetails)principal).getUsername(); // 사용자의 Id
		
		model.addAttribute("id", id);
		
		return "/freeboard/write";
	}
	
	// 게시글 등록화면에서 데이터 넘어오면 DB 저장
	@PostMapping("/post")
	public String write(BoardRequestDto boardRequestDto) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // 현재 로그인한 사용자의 정보를 가져온다
		String id = ((UserDetails)principal).getUsername(); // 사용자의 Id
		
		boardService.savePost(id, boardRequestDto);
		
		return "redirect:/freeboard";
	}
	
	// 게시글 상세보기
	@GetMapping("/post/{no}")
    public String detail(@PathVariable("no") int no, Model model) {
        BoardResponseDto boardDTO = boardService.getPost(no);
        List<CommentResponseDto> comments = boardDTO.getComments();
        
        boolean isLogin = false;
        boolean isWriter = false;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // 현재 로그인한 사용자의 정보를 가져온다
        
        // 로그인 상태 체크
        if (!principal.toString().equals("anonymousUser")) {
        	String id = ((UserDetails)principal).getUsername(); // 사용자의 Id
        	
        	isLogin = true;
        	model.addAttribute("loginUser", id);
        	
        	// 게시글 작성자 본인확인
        	if (boardDTO.getMid().equals(id)) {
        		isWriter = true;
        	} 
        }
        
        model.addAttribute("isLogin", isLogin);
        model.addAttribute("isWriter", isWriter);
        
        // 조회수 증가
        boardService.updateCount(no);
        
        // 댓글 관련 기능
        if (comments != null && !comments.isEmpty()) {
        	model.addAttribute("comments", comments);
        	model.addAttribute("commentsCnt", comments.size());
        } else {
        	model.addAttribute("commentsCnt", 0);
        }
        
        model.addAttribute("boardDto", boardDTO);
        
        return "/freeboard/detail";
    }

	// 게시글 수정
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") int no, Model model) {
        BoardResponseDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        
        return "/freeboard/update";
    }

    // 게시글 수정 값 DB 저장
    @PutMapping("/post/edit/{no}")
    public String update(BoardRequestDto boardDTO) {
    	
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // 현재 로그인한 사용자의 정보를 가져온다
		String id = ((UserDetails)principal).getUsername(); // 사용자의 Id
    	
        boardService.savePost(id, boardDTO);

        return "redirect:/freeboard";
    }
    
    // 게시글 삭제 실행
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") int no) {
        boardService.deletePost(no);

        return "redirect:/freeboard";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam(value="keyword", defaultValue="") String keyword, @RequestParam(value="page", defaultValue = "1") Integer pageNum, @RequestParam(value="filter", defaultValue="title") String filter, Model model) {
    	// List<BoardDto> boardDtoList = boardService.searchPosts(keyword, pageNum);
        List<BoardResponseDto> boardDtoList = boardService.searchPosts(keyword, filter, pageNum);
        Integer[] pageList = boardService.getPageList(pageNum, keyword, filter);
        
        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("filter", filter);
        model.addAttribute("currentPage", pageNum);
        addPrevNext(pageList, pageNum, keyword, filter, model);
        
        return "/freeboard/list";
    }
    
    
    public void addPrevNext(Integer [] pageList, Integer pageNum, Model model) {
    	addPrevNext(pageList, pageNum, "", "", model);
    }
    
    // prev, next 버튼 구현
    public void addPrevNext(Integer [] pageList, Integer pageNum, String keyword, String filter, Model model) {
    	
		int prev = boardService.getPrev(pageNum, keyword, filter);  // << 버튼값
		int next = boardService.getNext(pageNum, keyword, filter);  // >> 버튼값
    	
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
    }
}
