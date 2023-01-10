package com.study.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
	
	private String board_idx;
	private String board_title;
	private String board_contents;
	private String board_name;
	private Date board_date;
	private int board_hit;
	
	public BoardDto() {
		
	}
	
	public BoardDto(String board_idx, String board_title, String board_contents, String board_name, Date board_date,
			int board_hit) {
		super();
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_contents = board_contents;
		this.board_name = board_name;
		this.board_date = board_date;
		this.board_hit = board_hit;
	}

}
