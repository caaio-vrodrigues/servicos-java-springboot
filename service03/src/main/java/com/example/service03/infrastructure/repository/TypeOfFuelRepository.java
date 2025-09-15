package com.example.service03.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service03.infrastructure.entity.TypeOfFuel;

@Repository
public interface TypeOfFuelRepository extends JpaRepository<TypeOfFuel, Long> {}
