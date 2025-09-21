package com.example.servico05.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servico05.infrastructure.entity.UserClient;
import com.example.servico05.service.UserClientService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserClientController {

	private final UserClientService service;
	
	@PostMapping
	public ResponseEntity<UserClient> createUser(@RequestBody UserClient user) {
		return ResponseEntity.ok(service.createUser(user));
	}
	
	@GetMapping("/csfr-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping
	public ResponseEntity<List<UserClient>> listUsers(HttpServletRequest request) {
		return ResponseEntity.ok(service.searchAllUsers());
	} 
	
	@PostMapping("/login")
	public String login(@RequestBody UserClient user) {
		System.out.println(user);
		return "Succes";
	}
}
