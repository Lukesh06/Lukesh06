package com.ekalavya.security.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityServiceImpl implements UserDetailsService {

	@Value("${application.userName}")
	private String userName;

	@Value("${application.password}")
	private String rawPassword;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (userName.equals(username)) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password = passwordEncoder.encode(rawPassword);
			//List<SimpleGrantedAuthority> roles = new ArrayList<>();
			//SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("admin");
			//roles.add(simpleGrantedAuthority);
			return new User(userName, password, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
