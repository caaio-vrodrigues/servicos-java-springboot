package com.example.service03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service03.infrastructure.entity.TypeOfFuel;
import com.example.service03.infrastructure.repository.TypeOfFuelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeOfFuelService {
	private final TypeOfFuelRepository repo;
	
	public TypeOfFuel createTypeOfFuel(TypeOfFuel typeOfFuelBody) {
		return repo.saveAndFlush(typeOfFuelBody);
	}
	
	public TypeOfFuel searchTypeOfFuel(Long id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Tipo de combustível não encontrado."));
	}
	
	public List<TypeOfFuel> searchAllTypeOfFuel(){
		return repo.findAll();
	}
	
	public TypeOfFuel updateTypeOfFuel(Long id, TypeOfFuel typeOfFuelBody) {
		TypeOfFuel existsTypeOfFuel = searchTypeOfFuel(id);
		typeOfFuelBody.setId(existsTypeOfFuel.getId());
		return repo.saveAndFlush(typeOfFuelBody);
	}
	
	public void deleteTypeOfFuel(Long id) {
		repo.deleteById(id);
	}
}
