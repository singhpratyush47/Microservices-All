package com.eurekaclientsentence.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eurekaclientsentence.command.Word;

@Component
@FeignClient("LAB-4-NOUN")
public interface NounClient {

	@RequestMapping(method = RequestMethod.GET,value = "/")
	String getWord();
}
