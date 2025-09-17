package com.example.servico05.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.servico05.controller.UserClient;
import com.example.servico05.infrastructure.repository.UserClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserClientService {

	private final UserClientRepository repo;
	private final PasswordEncoder passwordEncoder;
	
	public UserClient createUser(String username, String password) {
		String cryptPassword = passwordEncoder.encode(password);
		UserClient newUser = UserClient.builder()
			.username(username)
			.password(cryptPassword)
			.build();
		return repo.saveAndFlush(newUser);
	}
	
	public UserClient serachUserClientById(Long id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Usuário não foi encontrado"));
	}
}
