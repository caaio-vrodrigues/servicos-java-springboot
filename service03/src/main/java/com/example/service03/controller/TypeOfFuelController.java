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

import com.example.service03.infrastructure.entity.TypeOfFuel;
import com.example.service03.service.TypeOfFuelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/typefuel")
public class TypeOfFuelController {
	private final TypeOfFuelService service;
	
	@PostMapping
	public ResponseEntity<TypeOfFuel> newTypeOfFuel(
		@RequestBody TypeOfFuel typeOfFuelBody
	){
		return ResponseEntity.ok(service.createTypeOfFuel(typeOfFuelBody));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TypeOfFuel> getTypeOfFuelById(@PathVariable Long id){
		return ResponseEntity.ok(service.searchTypeOfFuel(id));
	}
	
	@GetMapping
	public ResponseEntity<List<TypeOfFuel>> getListTypeOfFuel(){
		return ResponseEntity.ok(service.searchAllTypeOfFuel());
	}
	
	@PutMapping
	public ResponseEntity<TypeOfFuel> editTypeOfFuel(
		Long id, 
		@RequestBody TypeOfFuel typeOfFuelBody
	){
		return ResponseEntity.ok(service.updateTypeOfFuel(id, typeOfFuelBody));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excludeTypeOfFuel(@PathVariable Long id){
		service.deleteTypeOfFuel(id);
		return ResponseEntity.ok().build();
	}
}
