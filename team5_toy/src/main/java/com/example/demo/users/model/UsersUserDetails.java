package com.example.demo.users.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsersUserDetails extends User {

	private static final long serialVersionUID = -3668529733845897821L;

	public UsersUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

}
