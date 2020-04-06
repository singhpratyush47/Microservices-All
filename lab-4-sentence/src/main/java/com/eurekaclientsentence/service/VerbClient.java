package com.eurekaclientsentence.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("LAB-4-VERB")
public interface VerbClient {

	@RequestMapping(method = RequestMethod.GET,value = "/")
	String getWord();
}
