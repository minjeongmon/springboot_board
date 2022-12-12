package com.study.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.study.board.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {
	
	// DB 조인 걸어서 쿼리문 한개만 띄울 수 있음 //
	@EntityGraph(attributePaths = { "boards" })
	List<User> findAll();
	
	User findByUsername(String username);
	
	@Query("select u from User u where u.username like %?1%")
	List<User> findByUsernameQuery(String username);
	
	
	// 원래 Query문 사용 가능
	@Query(value= "select * from User u where u.username like %?1%", nativeQuery = true)
	List<User> findByUsernameNativeQuery(String username);

}
