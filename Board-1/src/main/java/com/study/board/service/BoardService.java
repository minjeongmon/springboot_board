package com.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.dao.BoardDao;
import com.study.board.dto.BoardDto;
import com.study.board.dto.Criteria;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	// 페이징
	public List<BoardDto> listWithPaging(Criteria criteria) {
		return boardDao.listWithPaging(criteria);
	}
	
	// 게시글 전체 개수 구하기
	public int getTotalCount(Criteria criteria) {
		return boardDao.getTotalCount(criteria);
	}

}
