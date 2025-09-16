package com.example.service04.service;

import org.springframework.stereotype.Service;

import com.example.service04.infrastructure.entity.Product;
import com.example.service04.infrastructure.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository repo;
	
	public Product createProduct(Product productBody) {
		return repo.saveAndFlush(productBody);
	}
}
