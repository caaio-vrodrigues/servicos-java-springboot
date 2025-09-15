package com.example.service03.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service03.infrastructure.entity.FuelPump;
import com.example.service03.service.FuelPumpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fuelpump")
public class FuelPumpController {
	private final FuelPumpService service;
	
	@PostMapping
	public ResponseEntity<FuelPump> newFuelPump(
		@RequestBody FuelPump fuelPumpBody
	){
		return ResponseEntity.ok(service.createFuelPump(fuelPumpBody));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuelPump> searchFuelPump(@PathVariable Long id){
		return ResponseEntity.ok(service.searchFuelPumpById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<FuelPump>> listFuelPump(){
		return ResponseEntity.ok(service.searchAllFuelPump());
	}
	
	@PutMapping
	public ResponseEntity<FuelPump> editFuelPump(
		Long id, 
		@RequestBody FuelPump fuelPumpBody
	){
		return ResponseEntity.ok(service.updateFuelPump(id, fuelPumpBody));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excludeFuelPump(@PathVariable Long id){
		service.deleteFuelPump(id);
		return ResponseEntity.ok().build();
	}
}
