package com.eurekaclientsentence.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eurekaclientsentence.service.GetSentenceService;

@RestController
public class SentenceFeignController {

	private GetSentenceService sentenceService;
	
	public SentenceFeignController(GetSentenceService sentenceService) {
		super();
		this.sentenceService = sentenceService;
	}

	@GetMapping("/sentenceFeign")
	public String getSentence() {
		return sentenceService.getSentence();
	}
}
