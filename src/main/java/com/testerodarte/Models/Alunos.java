package com.testerodarte.Models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "alunos")
public class Alunos {
	
	@Id
	private BigInteger identificacao;
	private String nome;
	private Character sexo;
	private LocalDate data_nascimento;
	private BigInteger idade;
	private BigDecimal nota_1;
	private BigDecimal nota_2;
	private BigDecimal nota_3;
	private BigDecimal media = null;

	public Alunos(String nome, BigInteger idade, BigDecimal media) {
		this.nome = nome;
		this.idade = idade;
		this.media = media;
	}
}
