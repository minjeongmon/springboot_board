package com.study.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.board.model.Board;
import com.study.board.repository.BoardRepository;
import com.study.board.service.BoardService;
import com.study.board.validator.BoardValidator;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardValidator boardValidator;
	
	/*
	 * 리스트 조회 + 페이징 처리 JPA에서는 페이지가 0부터 시작함
	 */
	
	@GetMapping("/list")
	public String list(Model model, @PageableDefault(size = 4) Pageable pageable, 
			@RequestParam(required = false, defaultValue = "") String searchText) {
		
		// Page<Board> boards = boardRepository.findAll(pageable);
		Page<Board> boards = boardRepository.findByTitleContainingOrContentContainingOrderByIdDesc(searchText, searchText, pageable);
		
		int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4 );

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("boards", boards);
		
		return "board/list";
		
	}
	
	@GetMapping("/form")
	public String form(Model model, @RequestParam(required = false) Long id) {
		
		/* id가 null 일 때, form으로 새 board 생성 값이 있을 경우 board로 값을 넘기기 */
		if(id == null) {
			
			model.addAttribute("board", new Board());
			
		} else {
			
			Board board = boardRepository.findById(id).orElse(null);
			model.addAttribute("board", board);
			
		}
		
		return "board/form";
		
	}

	/* 게시글 저장 및 수정 & 유효성 검사*/
	@PostMapping("/form")
	  public String submitForm(@Valid Board board, BindingResult bindingResult, Authentication authentication) {
		
		boardValidator.validate(board, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "board/form";
		}

		String username = authentication.getName();
		
		boardService.save(username, board);
	    // boardRepository.save(board);
	    
	    return "redirect:/board/list";
	  }

}
