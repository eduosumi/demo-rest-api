package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.comida.ComidaPersist;
import com.example.demo.domain.comida.ComidaResponse;
import com.example.demo.service.ComidaService;

@RestController
@RequestMapping(value = "/comidas", produces = 	MediaType.APPLICATION_JSON_VALUE)
public class ComidaController {

	@Autowired
	private ComidaService comidaService;
	
	@PostMapping
	public ResponseEntity<Object> postPatternSpring(@RequestBody @Valid ComidaPersist comidaPersist) {
		
		ComidaResponse response = comidaService.post(comidaPersist);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(response.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(value = "/response")
	public ResponseEntity<ComidaResponse> post(@RequestBody @Valid ComidaPersist comidaPersist) {
		
		return new ResponseEntity<ComidaResponse>(comidaService.post(comidaPersist), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/cadastro-aleatorio")
	public void cadastrarAleatorio(@RequestParam int qtd) {
		comidaService.criarComidas(qtd);
	}
	
	@GetMapping
	public ResponseEntity<List<ComidaResponse>> listar() {

		return ResponseEntity.ok(comidaService.listarResponse());
	}
	
}
