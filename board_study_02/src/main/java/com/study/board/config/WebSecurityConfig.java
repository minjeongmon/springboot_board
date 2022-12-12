package com.study.board.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests((requests) -> requests
			/* antMatchars 사용 안되서 requestMatchers로 바꿨더니 작동됨 왜 그러는지는 모르겠음 */
				.requestMatchers("/","/account/register", "/css/**", "/api/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/account/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	
	
	/* 쿼리로 인증 설정 
	 * Authentication 로그인인증 , Authorization 로그인한 사용자의 권한처리 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .passwordEncoder(passwordEncoder())
	      /* DB의 사용자테이블 (user) */
	      /* 쿼리 작성 시 뒤에 띄어쓰기 있지 말것 */
	      .usersByUsernameQuery("select username, password, enabled "
	    		  + "from user "
	    		  + "where username = ?")
	      /* DB의 권한 테이블 (role) */
	      .authoritiesByUsernameQuery("select u.username, r.name "
	    		  + "from user_role ur inner join user u on ur.user_id = u.id "
	    		  + "inner join role r on ur.role_id = r.id "
	    		  + "where u.username = ?");
	}
	
	/* 비밀번호 암호화 static 추가해야 돌아감 이유는 모름;;  */
	@Bean
	public static PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}