package com.example.service02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service02.infrastructure.entities.Person;
import com.example.service02.infrastructure.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service // define a classe como um serviço spring
@RequiredArgsConstructor // substitui construtores e realiza injeção de dependências
public class PersonService {
	private final PersonRepository repo;
	
	// c (create)
	public Person createPerson(Person personBody) {
		return repo.saveAndFlush(personBody);
	}
	
	// r (read)
	public Person searchPersonById(Long id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Pessoa não encontrada."));
	}
	
	// r (read)
	public List<Person> listPerson(){
		return repo.findAll();
	}
	
	// u (update)
	public Person updatePerson(Long id, Person personBody) {
		Person existsPerson = searchPersonById(id);
		personBody.setId(existsPerson.getId());
		return repo.saveAndFlush(personBody);
	}
	
	// d (delete)
	public void deletePerson(Long id) {
		repo.deleteById(id);
	}
}
