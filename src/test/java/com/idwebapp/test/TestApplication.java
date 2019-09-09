package com.idwebapp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void contextLoads() {
		// $2a$10$TcLRc.TfG6y2VDqkugp25eCRT4DpkLk4GAK4kzsi67jUZ6Csfi2U2
		System.out.println(encoder.encode("123456"));		
	}
}
