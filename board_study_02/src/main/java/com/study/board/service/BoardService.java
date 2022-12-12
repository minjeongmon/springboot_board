package com.study.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.model.Board;
import com.study.board.model.User;
import com.study.board.repository.BoardRepository;
import com.study.board.repository.UserRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Board save(String username, Board board) {
		User user = userRepository.findByUsername(username);
		board.setUser(user);
		return boardRepository.save(board);
	}
}
