package com.example.service04.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import customexception.InvalidDiscountException;
import customexception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
	private static final String TIMESTAMP_KEY = "timestamp";
	private static final String STATUS = "status";
	private static final String ERROR = "error";
	private static final String MESSAGE = "message";
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleRessourceNotFound(
		ResourceNotFoundException e
	){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put(TIMESTAMP_KEY, LocalDateTime.now());
		body.put(STATUS, HttpStatus.NOT_FOUND.value());
		body.put(ERROR, "Recurso não encontrado");
		body.put(MESSAGE, e.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDiscountException.class)
	public ResponseEntity<Object> handleinvalidDiscount(
		InvalidDiscountException e
	){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put(TIMESTAMP_KEY, LocalDateTime.now());
		body.put(STATUS, HttpStatus.BAD_REQUEST.value());
		body.put(ERROR, "Valor não permitido");
		body.put(MESSAGE, e.getMessage());
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleRessourceNotFound(Exception e){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put(TIMESTAMP_KEY, LocalDateTime.now());
		body.put(STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put(ERROR, "Falha no servidor");
		body.put(MESSAGE, e.getMessage());
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
