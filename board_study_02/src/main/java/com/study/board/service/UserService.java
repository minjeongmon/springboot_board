package com.study.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.board.model.Role;
import com.study.board.model.User;
import com.study.board.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/* repository에 user 정보 저장 (사용자 권한 및 비밀번호 암호화) */
	public User save(User user) {
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setEnabled(true);
		
		Role role = new Role();
		role.setId(1l);
		user.getRoles().add(role);
		
		return userRepository.save(user);
	}

}
