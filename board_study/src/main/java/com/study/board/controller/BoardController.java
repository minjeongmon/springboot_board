package com.study.board.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/write")	// localhost:8080/board/write
	public String boardWriteForm() {
		
		return "boardwrite";
		
	}
	
	@PostMapping("/board/writedo")
	public String boardWriteDo(Board board, Model model, MultipartFile file) throws Exception {
		
		boardService.boardWrite(board, file);
		
		model.addAttribute("message", "글 작성이 완료 되었습니다.");
		model.addAttribute("searchUrl", "/board/list");
		
		return "message";
	}
	
	
	@GetMapping("/board/list")
	public String boardList(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.DESC) Pageable pageable,
							String searchKeyword) {
		
		Page<Board> list = null;
		
		/* 게시글 검색, 검색 단어가 없으면 리스트 노출 */
		if (searchKeyword == null) {
			list = boardService.boardList(pageable);
		} else {
			list = boardService.boardSearchList(searchKeyword, pageable);
		}
		
		
		/* JpaRepository에서 제공하는 페이징 처리 사용 */
		int nowPage = list.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage - 4, 1);
		int endPage = Math.min(nowPage + 5, list.getTotalPages());
		
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "boardlist";
	}
	
	@GetMapping("/board/view")	// localhost:8080/board/view?id=1 < 게시글 번호 조회해서 게시글 내용 보여줌
	public String boardView(Model model, Integer id) {
		
		model.addAttribute("board", boardService.boardView(id));
		return "boardview";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Integer id) {
		
		boardService.boardDelete(id);
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("board", boardService.boardView(id));
		
		return "boardmodify";
	}
	
	@PostMapping("/board/update/{id}")
	public String boardUpdate(@PathVariable("id") Integer id, Board board, Model model, MultipartFile file) throws Exception {
		
		Board boardTemp = boardService.boardView(id);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContent(board.getContent());
		boardService.boardWrite(boardTemp, file);
		
		model.addAttribute("message", "수정이 완료 되었습니다.");
		model.addAttribute("searchUrl", "/board/list");
		
		return "message";
		/* return "redirect:/board/list"; */
	}

}
