package com.example.servico05.service;

import org.springframework.stereotype.Service;

import com.example.servico05.infrastructure.entity.Product;
import com.example.servico05.infrastructure.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository repo;
	
	public Product createProduct(Product productBody) {
		return repo.saveAndFlush(productBody);
	}
	
	public Product searchById(Long id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Produto não encontrado"));
	}
}
