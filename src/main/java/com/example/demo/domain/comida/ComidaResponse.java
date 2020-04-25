package com.example.demo.domain.comida;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class ComidaResponse implements Serializable {

	private static final long serialVersionUID = 8024959039505804055L;

	private Long id;
	
	private String nome;
	
	private String cor;
	
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate validade;

	public ComidaResponse(Long id, String nome, String cor, LocalDate validade) {
		this.id = id;
		this.nome = nome;
		this.cor = cor;
		this.validade = validade;
	}
	
	public ComidaResponse() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}
