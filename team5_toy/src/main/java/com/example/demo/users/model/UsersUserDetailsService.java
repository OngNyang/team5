package com.example.demo.users.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.users.service.IUserService;


@Component
public class UsersUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsersVO userInfo = userService.selectUser(username);
		if (userInfo == null) {
			throw new UsernameNotFoundException("[" + username + "] 사용자 없어요");
		}
		
		String[] roles = new String[1];
		roles[0] = userInfo.getRole();		
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roles);
		
		return new UsersUserDetails(userInfo.getEmail(), userInfo.getPassword(),
				authorities);
	}
}
