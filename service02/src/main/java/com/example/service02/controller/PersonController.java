package com.example.service02.controller;

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

import com.example.service02.infrastructure.entities.Person;
import com.example.service02.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController // define a classe como um serviço rest
@RequiredArgsConstructor // Substitui construtores e realiza injeção de dependências semântica
@RequestMapping("/api") // cria uma uri
public class PersonController {
	private final PersonService service;
	
	@PostMapping
	public ResponseEntity<Person> newPerson(@RequestBody Person personBody){
		return ResponseEntity.ok(service.createPerson(personBody));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> searchPerson(@PathVariable Long id){
		return ResponseEntity.ok(service.searchPersonById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> searchAllPerson(){
		return ResponseEntity.ok(service.listPerson());
	}
	
	@PutMapping
	public ResponseEntity<Person> editPerson(
		Long id,
		@RequestBody Person personBody
	){
		return ResponseEntity.ok(service.updatePerson(id, personBody));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excludePerson(@PathVariable Long id){
		service.deletePerson(id);
		return ResponseEntity.ok().build();
	}
}
