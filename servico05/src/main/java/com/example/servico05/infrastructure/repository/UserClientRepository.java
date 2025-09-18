package com.example.servico05.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servico05.infrastructure.entity.UserClient;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Long> {
	UserClient findByUsername(String username);
}
