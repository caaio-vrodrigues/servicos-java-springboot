package com.example.service02.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // define uma entidade
@Table(name="person_test") // cria uma tabela
@NoArgsConstructor // construtor sem argumentos obrigatório para o JPA funcionar
@AllArgsConstructor // construtor com todos os argumentos para criação de entidade
@Data // gera os metodos getters e setters para cada um dos atributos da entidade
@ToString // gera método toString que inclui os nomes e valores de todos os campos da classe
@Builder // trabalha em conjunto com @AllArgsConstructor e @Data utilizando setters na build de uma nova entidade
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private Integer age;
}
