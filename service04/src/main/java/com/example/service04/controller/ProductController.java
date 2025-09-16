package com.example.service04.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service04.infrastructure.entity.Product;
import com.example.service04.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
	private final ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> newProduct(@RequestBody Product productBody){
		return ResponseEntity.ok(service.createProduct(productBody));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> searchProduct(@PathVariable Long id){
		return ResponseEntity.ok(service.searchProductById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		service.deleteProductById(id);
		return ResponseEntity.ok("Produto deletado com sucesso.");
	}
	
	@PutMapping
	public ResponseEntity<Product> defineDiscount(Long id, @RequestParam BigDecimal discount){
		return ResponseEntity.ok(service.calculateAndSetDiscount(id, discount));
	}
}
