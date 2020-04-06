package com.springconfigclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringConfigClientApplicationTests {

	@Value("${wordConfig.preamble}")
	private String prop1;
	
	@Value("${wordConfig.luckyWord}")
	private String prop2;
	@Test
	public void testPropertyFromConfigServer() {
		System.out.println("property 1 ==>"+prop1);
		System.out.println("property 2 ==>"+prop2);
	}
}
