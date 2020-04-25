package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.ComidaService;

@Configuration
public class InsertDataBase {

	@Bean
	CommandLineRunner initDatabase(ComidaService comidaService) {
		return args -> {
			comidaService.criarComidas(10);
			System.err.println("EFETUADO CADASTRO DE COMIDAS PADRAO!!!!!!!!!!!!");
		};
	}
	
}
