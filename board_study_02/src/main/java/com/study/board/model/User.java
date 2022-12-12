package com.study.board.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private Boolean enabled;
	
	/* 테이블 맵핑 : 양방향맵핑으로 */
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		name = "user_role", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();
	
	// cascade 사용 하면 FK걸려있는 테이블도 조작 가능 
	// @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
	
	// fetch = FetchType.EAGER : user 정보 가져올때 board 정보 같이 가져옴, lazy Board를 사용하면 board 정보 먼저 조회
	// fetch는 many to one or one to many 사용 시 사용 가능함, 사용하는 이유는 성능 과부하를 막기 위해 (필요없는 데이터 조회하지 않게)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Board> boards = new ArrayList<>();

}
