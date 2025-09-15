package com.example.service01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service01.service.TestService;

@RestController 
@RequestMapping("/api")
public class TestController {
	private final TestService service;
	
	public TestController(TestService service) {
		this.service = service;
	}
	
	@GetMapping("/msg")
	public String getTestMsg() {
		return service.getTestMsg();
	}
}
