package com.study.board.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;

import jakarta.persistence.Id;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	// 게시글 작성 처리
	public void boardWrite(Board board, MultipartFile file) throws Exception{
		
		//파일 업로드
		String projectPath = System.getProperty("user.dir") + "/src/main/webapp";
		UUID uuid =UUID.randomUUID();
		String fileName = uuid + "_" + file.getOriginalFilename();
		File saveFile = new File(projectPath, fileName);
		file.transferTo(saveFile);
		
		board.setFilename(fileName);
		board.setFilepath("/webapp/" + fileName);
		
		boardRepository.save(board);
	}
	
	
	// 게시물 리스트 처리
	public Page<Board> boardList(Pageable pageable) {
		
		return boardRepository.findAll(pageable);
		
	}
	
	// 게시글 리스트에서 검색
	public Page<Board> boardSearchList(String searchKeyword, Pageable pageable) {
		
		return boardRepository.findByTitleContaining(searchKeyword, pageable);
		
	}
	
	// 게시글 내용 조회
	
	public Board boardView(Integer id) {
		
		return boardRepository.findById(id).get();
	}
	
	// 게시글 삭제
	
	public void boardDelete(Integer id) {
		
		boardRepository.deleteById(id);
		
	}

}
