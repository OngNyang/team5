package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests()
	    .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
	    .requestMatchers("/board").hasAnyRole("USER", "ADMIN")
	    .requestMatchers("/grade").hasAnyRole("USER", "ADMIN")
	    .requestMatchers("/likes").hasAnyRole("USER", "ADMIN")
	    .requestMatchers("/**", "/css/**", "/js/**", "/images/**").permitAll()
	    .requestMatchers("/user/register", "/user/login").permitAll()
	    .and()
	    .formLogin()
	        .loginPage("/user/login")
	        .usernameParameter("email")
	        .defaultSuccessUrl("/user/login/result")
	    .and()
	    .logout()
	        .logoutUrl("/user/logout")
	        .logoutSuccessUrl("/user/logout/result")
	        .invalidateHttpSession(true)
	    .and()
	    .csrf().disable();
		return http.build();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
