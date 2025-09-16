package com.example.service03.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service03.infrastructure.entity.FuelSupply;

@Repository
public interface FuelSupplyRepository extends JpaRepository<FuelSupply, Long>{}
