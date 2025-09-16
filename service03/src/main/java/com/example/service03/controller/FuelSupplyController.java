package com.example.service03.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service03.infrastructure.entity.FuelSupply;
import com.example.service03.service.FuelSupplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fuelsupply")
public class FuelSupplyController {
	private final FuelSupplyService service;
	
	@PostMapping
	public ResponseEntity<FuelSupply> newFuelSupply(
		Long idPump,
		BigDecimal totalLiters
	){
		return ResponseEntity.ok(service.createFuelSupply(idPump, totalLiters));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuelSupply> searchFuelSupply(@PathVariable Long id){
		return ResponseEntity.ok(service.searchFuelSupplyById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<FuelSupply>> listFuelSupply(){
		return ResponseEntity.ok(service.searchAllFuelSupply());
	}
}
