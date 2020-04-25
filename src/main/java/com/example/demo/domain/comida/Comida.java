package com.example.demo.domain.comida;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.enums.Cor;

@Entity
public class Comida {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cor;
	
	private LocalDate validade;

	public Comida(String nome, Cor cor, LocalDate validade) {
		this.nome = nome;
		this.cor = cor.name();
		this.validade = validade;
	}
	
	public Comida() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	
	public ComidaResponse convert() {
		return new ComidaResponse(id, nome, cor, validade);
	}
	
}
