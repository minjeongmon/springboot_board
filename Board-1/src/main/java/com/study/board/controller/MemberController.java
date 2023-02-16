package com.study.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.board.dto.MemberDto;
import com.study.board.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// 회원가입 페이지
	@GetMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}

	// 로그인 페이지
	@GetMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	
	// 회원가입
	@PostMapping("join")
	public String joinPost(MemberDto memberDto) throws Exception {
		memberService.memberJoin(memberDto);
		return "redirect:/loginForm";
	}

	
	@PostMapping("login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) throws Exception {
	
		memberDto = memberService.login(memberDto);
		
		/* 세션에 로그인 회원 정보 저장 */
		if(memberDto != null) {
			
			session.setAttribute("authUser", memberDto);
			return "redirect:/boardList";
			
		} else {
			
			return "loginForm";
			
		}
	      
	}
	
	/* 로그아웃 기능 
	 * session 정보 지우기 */
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception {
		
		session.removeAttribute("authUser");
		
		return "redirect:/loginForm";
	}
	

	/* 회원 가입 
	
	@PostMapping("join")
	public String join(MemberDto memberDto) throws Exception {
		int result = memberService.join(memberDto);
		
		if(result == 1) {
			return "redirect:login";
		}
		
			return "redirect:joinForm";
	} */
	
	
	/* 중복체크 
	@RequestMapping("idCheck")
	
	public @ResponseBody int idCheck(String userId) {
		
		int result = memberDao.idCheck(userId);
		return result;
	}
	*/
}
