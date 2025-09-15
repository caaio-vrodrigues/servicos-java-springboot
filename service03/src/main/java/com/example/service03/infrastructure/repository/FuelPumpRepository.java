package com.example.service03.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service03.infrastructure.entity.FuelPump;

@Repository
public interface FuelPumpRepository extends JpaRepository<FuelPump, Long> {}
