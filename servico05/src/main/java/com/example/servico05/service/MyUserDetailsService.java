package com.example.servico05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.servico05.infrastructure.entity.UserClient;
import com.example.servico05.infrastructure.entity.UserClientPrincipals;
import com.example.servico05.infrastructure.repository.UserClientRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserClientRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserClient user = repo.findByUsername(username);
		if(user == null) throw new UsernameNotFoundException("Usuário não encontrado");
		return new UserClientPrincipals(user);
	}
}
