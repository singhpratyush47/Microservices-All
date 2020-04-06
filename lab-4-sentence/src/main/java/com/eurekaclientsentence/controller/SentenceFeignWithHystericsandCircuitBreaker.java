package com.eurekaclientsentence.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaclientsentence.service.GetSentenceService;

@RestController
public class SentenceFeignWithHystericsandCircuitBreaker {

	private static final String SPACE = " ";
	private GetSentenceService sentenceService;
	
	public SentenceFeignWithHystericsandCircuitBreaker(GetSentenceService sentenceService) {
		super();
		this.sentenceService = sentenceService;
	}

	@GetMapping("/sentenceWithFeignAndHysterix")
	public String getSentence() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(sentenceService.getSubject());
		stringBuilder.append(SPACE);
		stringBuilder.append(sentenceService.getVerb());
		stringBuilder.append(SPACE);
		stringBuilder.append(sentenceService.getArticle());
		stringBuilder.append(SPACE);
		stringBuilder.append(sentenceService.getAdjective());
		stringBuilder.append(SPACE);
		stringBuilder.append(sentenceService.getNoun());
		stringBuilder.append(".");
		return  stringBuilder.toString();
	}
}
