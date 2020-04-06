package com.springconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LuckyWordController {

//  Notice how the prefix of "wordConfig" 
	//  must be repeated without @ConfigurationProperties:	
	@Value("${word-config.luckyWord}") String luckyWord;
	@Value("${word-config.preamble}") String preamble;
	
	@GetMapping("/lucky-word-refreshed")
	public String showLuckyWord() {
		return preamble + ": " + luckyWord;
	}
}
