package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.constant.Method;
import com.board.domain.BoardDTO;
import com.board.service.BoardService;
import com.board.util.UiUtils;

@Controller
public class BoardController {
	
	@Autowired
	private UiUtils uiUtils;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value="/board/write.do")
	public String openBoardWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) {
		
		if(idx == null) {
			model.addAttribute("board", new BoardDTO());
		} else {
			BoardDTO board = boardService.getBoardDetail(idx);
			if (board == null) {
				return "redirect:/board/list.co";
				}
			model.addAttribute("board", board);
		}
		return "board/write";
	}
	
	@PostMapping(value = "/board/register.do")
	public String registerBoard(final BoardDTO params, Model model) {
		try {
			boolean isRegistered = boardService.registerBoard(params);
			if (isRegistered == false) {
				// TODO => �Խñ� ��Ͽ� �����Ͽ��ٴ� �޽����� ����
				return uiUtils.showMessageWithRedirect("�Խñ� ��Ͽ� �����Ͽ����ϴ�.", "/board/list.do", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			// TODO => �����ͺ��̽� ó�� ������ ������ �߻��Ͽ��ٴ� �޽����� ����
			return uiUtils.showMessageWithRedirect("�����ͺ��̽� ó�� ������ ������ �߻��Ͽ����ϴ�.", "/board/list.do", Method.GET, null, model);

		} catch (Exception e) {
			// TODO => �ý��ۿ� ������ �߻��Ͽ��ٴ� �޽����� ����
			return uiUtils.showMessageWithRedirect("�ý��ۿ� ������ �߻��Ͽ����ϴ�.", "/board/list.do", Method.GET, null, model);
		}
		return uiUtils.showMessageWithRedirect("�Խñ� ����� �Ϸ�Ǿ����ϴ�.", "/board/list.do", Method.GET, null, model);
	}
	
	@GetMapping(value = "/board/list.do")
	public String openBoardList(Model model) {
		List<BoardDTO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	@GetMapping(value = "/board/view.do")
	public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
		if(idx == null) {
			return "redirect:/board/list.do";
		}
		
		BoardDTO board = boardService.getBoardDetail(idx);
		if(board == null || "Y".equals(board.getDeleteYn())) {
			return "redirect:/board/list.do";
		}
		model.addAttribute("board", board);
		
		return "board/view";
			
	}

	@PostMapping(value = "/board/delete.do")
	public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx, Model model) {
		if(idx == null) {
			
			return uiUtils.showMessageWithRedirect("�ùٸ��� ���� �����Դϴ�.", "/board/list.do", Method.GET, null, model);
		}
		try {
			boolean isDeleted = boardService.deleteBoard(idx);
				if(isDeleted == false) {
					return uiUtils.showMessageWithRedirect("�Խñ� ������ �����Ͽ����ϴ�.", "/board/list.do", Method.GET, null, model);
				}
			} catch (DataAccessException e) {
				return uiUtils.showMessageWithRedirect("�����ͺ��̽� ó�� ������ ������ �߻��Ͽ����ϴ�.", "/board/list.do", Method.GET, null, model);
			} catch (Exception e) {
				return uiUtils.showMessageWithRedirect("�ý��ۿ� ������ �߻��Ͽ����ϴ�.", "/board/list.do", Method.GET, null, model);
			}
				
		return uiUtils.showMessageWithRedirect("�Խñ� ������ �Ϸ�Ǿ����ϴ�.", "/board/list.do", Method.GET, null, model);
		
	}
	
}
