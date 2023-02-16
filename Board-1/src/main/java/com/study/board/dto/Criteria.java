package com.study.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	// 페이징 처리를 위한 변수
	private int pageNum;		// 현재 페이지 - page
	private int amount;			// 한 페이지 당 표시되는 게시물 갯수 - perPageNum
	
	
	// 검색 처리를 위한 변수
	// private String type;		// 검색 항목
	// private String keyword;		// 검색 할 단어
	
	
	/*
	 * 변수 값을 세팅 하는 방법 1. 초기화 블록 사용 : {~~~~~} 2. 생성자 : 클래스명() {~~~~~} 3. setter method : setter()
	 */
	
	public Criteria() {
		this.pageNum = 1;			// 기본 페이지 : 1페이지
		this.amount = 10;			// 한페이지에 표시되는 게시물 : 10개
	}
	
	//public String getKeyword() {
	//	return keyword;
	//}
	
	
	
}
