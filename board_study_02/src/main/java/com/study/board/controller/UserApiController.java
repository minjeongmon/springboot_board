package com.study.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.board.model.Board;
import com.study.board.model.User;
import com.study.board.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
class UserApiController {

	@Autowired
	private UserRepository repository;

	/* 사용자 검색 */
	@GetMapping("/users")
	List<User> all(@RequestParam(required = false) String method, @RequestParam(required = false) String text)  {
		
		List<User> users = null;
		
		if("query".equals(method)) {
			users = repository.findByUsernameQuery(text);
		} else if("nativeQuery".equals(method)) {
			users = repository.findByUsernameNativeQuery(text);
		} else {
			users = repository.findAll();
		}
		
		return users;
	}

	@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}

	// Single item

	@GetMapping("/users/{id}")
	User one(@PathVariable Long id) {

		return repository.findById(id).orElse(null);
	}

	@PutMapping("/users/{id}")
	User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
		// api 를 이용해서 user로 접근해도 게시글 작성 가능 //
		return repository.findById(id).map(user -> {
			// user.setTitle(newUser.getTitle());
			// user.setContent(newUser.getContent());
			user.setBoards(newUser.getBoards());
			for(Board board : user.getBoards()) {
				board.setUser(user);
			}
			return repository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return repository.save(newUser);
		});
	}

	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
