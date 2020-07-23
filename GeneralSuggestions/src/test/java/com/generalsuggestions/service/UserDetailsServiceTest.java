package com.generalsuggestions.service;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {

	@Test
	public void generate_encrypted_password()
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword="password123";
		String encodedPassword = encoder.encode(rawPassword);
		
		assertThat(rawPassword, not(encodedPassword));
	}

}
