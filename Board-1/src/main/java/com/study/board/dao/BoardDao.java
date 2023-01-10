package com.study.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.dto.BoardDto;

@Mapper
public interface BoardDao {
	
	public List<BoardDto> list();
	
	public int write(BoardDto boardDto);
	
	public BoardDto viewDto(String board_idx);
	
	public int updateDto(BoardDto boardDto);
	
	public int deleteDto(String board_idx);
	
	public int hit(String board_idx);

}
