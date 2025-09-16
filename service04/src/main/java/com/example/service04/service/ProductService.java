package com.example.service04.service;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Service;

import com.example.service04.infrastructure.entity.Product;
import com.example.service04.infrastructure.repository.ProductRepository;

import customexception.InvalidDiscountException;
import customexception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository repo;
	
	public Product createProduct(Product productBody) {
		return repo.saveAndFlush(productBody);
	}
	
	public Product searchProductById(Long id) {
		return repo.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Produto não encontrado para o id: "+id));
	}
	
	public void deleteProductById(Long id) {
		if(!repo.existsById(id)) 
			throw new ResourceNotFoundException("Produto não encontrado para o id: "+id);
		repo.deleteById(id);
	}
	
	public Product calculateAndSetDiscount(Long id, BigDecimal discount) {
		Product product = searchProductById(id);
		BigDecimal discountPercentage = discount.divide(BigDecimal.valueOf(100), MathContext.DECIMAL128);
		BigDecimal discountTotal = product.getPrice().multiply(discountPercentage);
		if(discountTotal.doubleValue() >= 10.0) throw new InvalidDiscountException("Desconto acima do limite para o id: "+id);
		product.setDiscount(discountTotal);
		return product;
	}
}
