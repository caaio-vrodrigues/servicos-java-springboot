package com.example.servico05.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servico05.infrastructure.entity.Product;
import com.example.servico05.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
	private final ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> newProduct(@RequestBody Product productBody){
		return ResponseEntity.ok(service.createProduct(productBody));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable Long id){
		return ResponseEntity.ok(service.searchById(id));
	}
}
