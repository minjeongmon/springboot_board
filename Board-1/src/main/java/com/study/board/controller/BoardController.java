package com.study.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.board.dao.BoardDao;
import com.study.board.dao.ReplyDao;
import com.study.board.dto.BoardDto;
import com.study.board.dto.Criteria;
import com.study.board.dto.PageDto;
import com.study.board.dto.ReplyDto;
import com.study.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String main() {
		return "home";
	}
	
	 
	/*
	 * @RequestMapping("/boardList") public String boardList(Model model,
	 * HttpSession session) {
	 * 
	 * List<BoardDto> list = boardDao.list(); model.addAttribute("list", list);
	 * 
	 * 
	 * return "boardList"; }
	 */
	
	@GetMapping("/boardList")
	public void list(Criteria criteria, Model model) {
		
		
		// DB에서 데이터 가져오기 - criteria 데이터만 필요
		model.addAttribute("list", boardService.listWithPaging(criteria));
		
		// 화면에 필요한 정보 가져오기&계산하기 (생성자에서 처리)
		model.addAttribute("pageMaker", new PageDto(criteria, boardService.getTotalCount(criteria)));
		// log.info(model);
		
		
		
	}


	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/writeAction")
	@ResponseBody
	public String writeAction(@ModelAttribute BoardDto boardDto) {
		
		int result = boardDao.write(boardDto);
		
		if( result == 1 ) {
			System.out.println("글쓰기 성공 :)");
			
			// return "redirect:boardList";
			return "<script>alert('글쓰기 성공 :)'); location.href='/boardList';</script>";
			
		} else {
			System.out.println("글쓰기 실패 :(");
			
			//return "redirect:writeForm";
			return "<script>alert('글쓰기 실패 :('); location.href='/writeForm';</script>";
		}
	}

	
	@RequestMapping("/contentForm")
	public String contentForm(@RequestParam("board_idx") String board_idx, Model model) {
		
		// 조회수 증가 //
		boardDao.hit(board_idx);
		
		// 게시물 상세내용 //
		BoardDto dto = boardDao.viewDto(board_idx);
		model.addAttribute("dto", dto);
		
		// 댓글 리스트 가져오기
		List<ReplyDto> reply_list = replyDao.reply_list(board_idx);
		model.addAttribute("reply_list", reply_list);
		
		return "contentForm";
		
	}
	
	@RequestMapping("/updateAction")
	@ResponseBody
	public String updateAction(@ModelAttribute BoardDto boardDto, HttpServletRequest request) {
		
		int result = boardDao.updateDto(boardDto);
		
		if( result == 1 ) {
			System.out.println("수정 성공 :)");
			return "<script>alert('수정 성공 :)'); location.href='/boardList';</script>";
			
		} else {
			System.out.println("수정 실패 :(");
			return "<script>alert('수정 실패 :('); location.href='/boardList';</script>";
		}
		
	}
	

	
	@RequestMapping("/deleteAction")
	@ResponseBody
	public String deleteAction(@RequestParam("board_idx") String board_idx, HttpServletRequest request) {
		
		int result = boardDao.deleteDto(board_idx);
		
		if( result == 1 ) {
			System.out.println("삭제 성공 :)");
			return "<script>alert('삭제 성공 :)'); location.href='/boardList';</script>";
		} else {
			System.out.println("삭제 실패 :(");
			return "<script>alert('삭제 실패 :)'); location.href='/boardList';</script>";
		}
		
	}

	
	@RequestMapping("/replyWrite")
	@ResponseBody
	public String replyWrite(@ModelAttribute ReplyDto replyDto, @RequestParam("reply_board_idx") String reply_board_idx, HttpServletRequest request) {
		
		int result = replyDao.reply_write(replyDto);
		
		if( result == 1 ) {
			System.out.println("글쓰기 성공 :)");
			return "<script>alert('글쓰기 성공 :)'); location.href='/contentForm?board_idx="+ reply_board_idx + "';</script>";
			
			
		} else {
			System.out.println("글쓰기 실패 :(");
			return "<script>alert('글쓰기 실패 :('); location.href='/contentForm?board_idx="+ reply_board_idx + "';</script>";
		}

	}
	
	@RequestMapping("/deleteReplyAction")
	@ResponseBody
	public String deleteReplyAction(@RequestParam("reply_idx") String reply_idx, @RequestParam("board_idx") String board_idx, HttpServletRequest request) {
		
		int result = replyDao.reply_deleteDto(reply_idx);
		
		if( result == 1 ) {
			System.out.println("삭제 성공 :)");
			return "<script>alert('삭제 성공 :)'); location.href='/contentForm?board_idx="+ board_idx + "';</script>";
		} else {
			System.out.println("삭제 실패 :(");
			return "<script>alert('삭제 실패 :)'); location.href='/contentForm?board_idx="+ board_idx + "';</script>";
		}
		
	}


}
