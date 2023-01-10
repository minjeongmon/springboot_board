package com.study.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.board.dto.ReplyDto;

@Mapper
public interface ReplyDao {
	
	public List<ReplyDto> reply_list( String reply_board_idx );
	
	public int reply_write(ReplyDto replyDto);
	
	public int reply_deleteDto(String reply_idx);

}
