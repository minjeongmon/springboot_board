package com.study.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.dto.BoardDto;
import com.study.board.dto.Criteria;

@Mapper
public interface BoardDao {
	
	// public List<BoardDto> list();
	
	// 게시판 리스트 불러오기 + 페이징
	public List<BoardDto> listWithPaging(Criteria criteria);
	
	public int getTotalCount(Criteria criteria);
	
	public int write(BoardDto boardDto);
	
	public BoardDto viewDto(String board_idx);
	
	public int updateDto(BoardDto boardDto);
	
	public int deleteDto(String board_idx);
	
	public int hit(String board_idx);

}
