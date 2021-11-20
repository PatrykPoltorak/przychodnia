package com.example.przychodnia.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.przychodnia.entity.UserPrincipal;
import com.example.przychodnia.entity.Users;
public class UsersDetailsService implements UserDetailsService {

	private UsersService usersService;	
	@Autowired
	public void setUsersRepository(UsersService usersService) {
		this.usersService = usersService;
	}	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersService.findByUserName(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		users.getRoles().forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
		System.out.println(users.getUsername() + users.getPassword() + grantedAuthorities + users);
		return new UserPrincipal(users.getUsername(),users.getPassword(),grantedAuthorities, users);
		}
}