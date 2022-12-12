package com.study.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;


/* @EnableGlobalMethodSecurity 사용 안됨 @EnableMethodSecurity
 * GlobalMethodSecurityConfiguration 도 사용안됨 PrePostMethodSecurityConfiguration, 
 * SecuredMethodSecurityConfiguration또는 Jsr250MethodSecurityConfiguration대신 사용 */
@Configuration
@EnableMethodSecurity(
		prePostEnabled = true, 
		securedEnabled = true, 
		jsr250Enabled = true)
public class MethodSecurityConfig {

}
