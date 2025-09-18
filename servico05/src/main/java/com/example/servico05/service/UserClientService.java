package com.example.servico05.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.servico05.infrastructure.entity.UserClient;
import com.example.servico05.infrastructure.repository.UserClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserClientService {

	private final UserClientRepository repo;
	private final BCryptPasswordEncoder passwordEncoder; 
	
	public UserClient createUser(UserClient user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.saveAndFlush(user);
	}
	
	public UserClient serachUserClientById(Long id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Usuário não foi encontrado"));
	}
	
	public List<UserClient> searchAllUsers(){
		return repo.findAll();
	}
}
