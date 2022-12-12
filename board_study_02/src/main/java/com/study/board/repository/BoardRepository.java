package com.study.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.study.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	List<Board> findByTitle(String title);
	List<Board> findByTitleOrContent(String title, String content);

	/* 페이징처리 + 검색 + 게시글 내림차순정렬 */
	Page<Board> findByTitleContainingOrContentContainingOrderByIdDesc (String title, String content, Pageable pageable);
}
