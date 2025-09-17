package com.example.servico05.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.servico05.infrastructure.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{}
