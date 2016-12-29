package com.onlineshop.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String args[]) throws Exception {
		String cryptedPassword = new BCryptPasswordEncoder().encode("123456789");
		System.out.println(cryptedPassword);
	}
}
