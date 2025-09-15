package com.example.service03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service03.infrastructure.entity.FuelPump;
import com.example.service03.infrastructure.repository.FuelPumpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuelPumpService {
	private final FuelPumpRepository repo;
	
	public FuelPump createFuelPump(FuelPump fuelPump) {
		return repo.saveAndFlush(fuelPump);
	}
	
	public FuelPump searchFuelPumpById(Long id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Bomba de combustível não encontrada."));
	}
	
	public List<FuelPump> searchAllFuelPump(){
		return repo.findAll();
	}
	
	public FuelPump updateFuelPump(Long id, FuelPump fuelPumpBody) {
		FuelPump existsFuelPump = searchFuelPumpById(id);
		fuelPumpBody.setId(existsFuelPump.getId());
		return repo.saveAndFlush(fuelPumpBody);
	}
	
	public void deleteFuelPump(Long id) {
		repo.deleteById(id);
	}
}
