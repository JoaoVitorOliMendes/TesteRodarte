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
	private BigDecimal nota_1;
	private BigDecimal nota_2;
	private BigDecimal nota_3;
	private BigDecimal media = null;

	public Alunos(BigInteger identificacao, String nome, BigDecimal media) {
		this.identificacao = identificacao;
		this.nome = nome;
		this.media = media;
	}
}
