package com.eurekaclientsentence.service;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GetSentenceServiceImpl implements GetSentenceService {

	private final NounClient nounClient;
	private final AdjectiveClient adjectiveClient;
	private final ArticleClient articleClient;
	private final SubjectClient subjectClient;
	private final VerbClient verbClient;
	private static final String SPACE=" ";
	
	public GetSentenceServiceImpl(NounClient nounClient, AdjectiveClient adjectiveClient, 
			ArticleClient articleClient,SubjectClient subjectClient, VerbClient verbClient) {
		super();
		this.nounClient = nounClient;
		this.adjectiveClient = adjectiveClient;
		this.articleClient = articleClient;
		this.subjectClient = subjectClient;
		this.verbClient = verbClient;
	}
	
	@Override
	public String getSentence() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(subjectClient.getWord());
		stringBuilder.append(SPACE);
		stringBuilder.append(verbClient.getWord());
		stringBuilder.append(SPACE);
		stringBuilder.append(articleClient.getWord());
		stringBuilder.append(SPACE);
		stringBuilder.append(adjectiveClient.getWord());
		stringBuilder.append(SPACE);
		stringBuilder.append(nounClient.getWord());
		stringBuilder.append(".");
		return stringBuilder.toString();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackNoun")
	public String getNoun() {
		return nounClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackAdjective")
	public String getAdjective() {
		return adjectiveClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackArticle")
	public String getArticle() {
		return articleClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackSubject")
	public String getSubject() {
		return subjectClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackVerb")
	public String getVerb() {
		return verbClient.getWord();
	}
	
	private String getFallbackVerb() {
		return "VERB";
		
	}
	
	private String getFallbackSubject() {
		return "SUBJECT";
	}

	private String getFallbackArticle() {
		return "ARTICLE";
	}
	
	private String getFallbackAdjective() {
		return "ADJECTIVE";
	}
	
	private String getFallbackNoun() {
		return "NOUN";
	}
}
