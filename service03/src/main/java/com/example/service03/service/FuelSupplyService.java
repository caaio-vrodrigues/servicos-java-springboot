package com.example.service03.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.service03.infrastructure.entity.FuelPump;
import com.example.service03.infrastructure.entity.FuelSupply;
import com.example.service03.infrastructure.repository.FuelSupplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuelSupplyService {
	private final FuelSupplyRepository repo;
	private final FuelPumpService fuelPumpService;
	
	public FuelSupply createFuelSupply(Long idPump, BigDecimal totalLiters) {
		FuelPump fuelPump = fuelPumpService.searchFuelPumpById(idPump);
		
		BigDecimal totalPayment = totalLiters.multiply(
			fuelPump.getTypeOfFuel().getPrice());
		
		FuelSupply newFuelSupply = FuelSupply.builder()
			.date(LocalDate.now())
			.fuelPump(fuelPump)
			.totalLiters(totalLiters)
			.totalPayment(totalPayment)
			.build();
		
		return repo.saveAndFlush(newFuelSupply);
	}
	
	public FuelSupply searchFuelSupplyById(Long id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Abastecimento não encontrado."));
	}
	
	public List<FuelSupply> searchAllFuelSupply(){
		return repo.findAll();
	}
}
