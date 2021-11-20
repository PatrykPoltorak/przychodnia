package com.example.przychodnia.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class UserPrincipal extends User{
	private final  com.example.przychodnia.entity.Users users;
	
	public UserPrincipal(String username, String password,
			Collection<? extends GrantedAuthority> authorities, Users users) {
		super(username, password, authorities);
		this.users = users;
	}
	public Users getUsers() {
		return users;
	}


}
