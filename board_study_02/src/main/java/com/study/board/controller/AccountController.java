package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.board.model.User;
import com.study.board.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		
		return "account/login";
		
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "account/register";
		
	}
	
	
	/* 회원 정보 저장 */
	@PostMapping("/register")
	public String register(User user) {
		
		userService.save(user);
		
		return "redirect:/";		// 로그인 완료 되면 홈으로 이동
		
	}

}
