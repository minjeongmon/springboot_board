package com.study.board.dao;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.dto.MemberDto;

@Mapper
public interface MemberDao {
	
	
	public MemberDto login(MemberDto memberDto) throws Exception;
	
	// public int join(MemberDto memberDto) throws Exception;
	
	// 회원가입
	public void memberJoin(MemberDto memberDto);
	

}
