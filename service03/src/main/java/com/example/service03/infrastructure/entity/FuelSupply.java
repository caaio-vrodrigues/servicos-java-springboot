package com.example.service03.infrastructure.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fuel_supply")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FuelSupply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="date")
	private LocalDate date;
	
	@OneToOne
	@JoinColumn(name="fuel_pump_id")
	private FuelPump fuelPump;
	
	@Column(name="total_liters")
	private BigDecimal totalLiters;
	
	@Column(name="total_payment")
	private BigDecimal totalPayment;
}
