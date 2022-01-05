package com.ekalavya.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class SecurityApplicationTests  {

	
	@Test
	void contextLoads() {
		BCryptPasswordEncoder BCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(BCryptPasswordEncoder.encode("password"));
	}
}
