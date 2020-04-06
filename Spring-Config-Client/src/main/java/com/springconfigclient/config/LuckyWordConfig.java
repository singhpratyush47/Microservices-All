package com.springconfigclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "word-config")
public class LuckyWordConfig {

	private String luckyWord;
	private String preamble;
	public LuckyWordConfig(String luckyWord, String preamble) {
		super();
		this.luckyWord = luckyWord;
		this.preamble = preamble;
	}
	public String getLuckyWord() {
		return luckyWord;
	}
	public void setLuckyWord(String luckyWord) {
		this.luckyWord = luckyWord;
	}
	public String getPreamble() {
		return preamble;
	}
	public void setPreamble(String preamble) {
		this.preamble = preamble;
	}
	@Override
	public String toString() {
		return "LuckyWordController [luckyWord=" + luckyWord + ", preamble=" + preamble + "]";
	}
}
