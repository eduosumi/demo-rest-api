package com.example.demo.domain.comida;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.enums.Cor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;


public class ComidaPersist implements Serializable {

	private static final long serialVersionUID = 7802541413227924115L;
	
	@NotEmpty
	private String nome;
	
	@NotNull
	private Cor cor;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate validade;

	public String getNome() {
		return nome;
	}

	public Cor getCor() {
		return cor;
	}

	public LocalDate getValidade() {
		return validade;
	}
	
	public Comida convertComida() {
		return new Comida(nome, cor, validade); 
	}
	
}
