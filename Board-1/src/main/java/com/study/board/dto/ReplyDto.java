package com.study.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyDto {
	
	private String reply_idx;
	private String reply_contents;
	private String reply_name;
	private Date reply_date;
	private String reply_board_idx;
	
	public ReplyDto() {
		
	}
	
	public ReplyDto(String reply_idx, String reply_contents, String reply_name, Date reply_date,
			String reply_board_idx) {
		super();
		this.reply_idx = reply_idx;
		this.reply_contents = reply_contents;
		this.reply_name = reply_name;
		this.reply_date = reply_date;
		this.reply_board_idx = reply_board_idx;
	}
	

}
