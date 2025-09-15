package com.example.service01.service;

import org.springframework.stereotype.Service;

import com.example.service01.repository.TestRepository;

@Service
public class TestService {
	private final TestRepository repo;
	
	public TestService(TestRepository repo) {
		this.repo = repo;
	}
	
	public String getTestMsg() {
		return repo.msgTest;
	}
}
