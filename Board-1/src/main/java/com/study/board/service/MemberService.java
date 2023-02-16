package com.study.board.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.dao.MemberDao;
import com.study.board.dto.MemberDto;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	
	public MemberDto login(MemberDto memberDto) throws Exception {
		return memberDao.login(memberDto);
	}
	
	
	/*
	 * public int join(MemberDto memberDto) throws Exception { return
	 * memberDao.join(memberDto); }
	 */
	
	public void memberJoin(MemberDto memberDto) throws Exception {
		memberDao.memberJoin(memberDto);
	}


}
