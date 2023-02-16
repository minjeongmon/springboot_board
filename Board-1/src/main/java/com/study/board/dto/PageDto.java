package com.study.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDto {
	
	private int startPage;			// 화면 페이지네이션의 첫 페이지
	private int endPage;			// 화면 페이지네이션의 끝 페이지
	private boolean prev, next;		// 이전페이지, 다음페이지	- 페이지가 있으면 True, 없으면 False
	
	private int total;				// 전체 게시글	개수
	private Criteria criteria;		// 현재 페이지와 화면에 보여지는 데이터 개수
	
	
	// 생성자에서 값을 전달 받아 세팅
	public PageDto(Criteria criteria, int total) {
		
		this.criteria = criteria;
		this.total = total;
		
		// 화면에 보여 줄 마지막 페이지 계산하기, ceil-double형임 소수점 반올림
		this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0) * 10);
		this.startPage = this.endPage - 9;
		
		// 전체 데이터의 마지막 페이지 계산 - totalPage
		int realEnd = getTotalPage();
		
		// endPage는 realEnd를 초과 할 수 없다. 계산 결과가 초과 될 시 endPage를 realEnd로 바꿔줘야함
		if ( realEnd < endPage ) this.endPage = realEnd;
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
		
	}
	
	public int getTotalPage() {
		return (int)(Math.ceil((total * 1.0) / criteria.getAmount()));
	}

}
