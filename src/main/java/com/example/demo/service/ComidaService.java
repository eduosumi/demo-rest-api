package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.comida.Comida;
import com.example.demo.domain.comida.ComidaPersist;
import com.example.demo.domain.comida.ComidaResponse;
import com.example.demo.enums.Cor;
import com.example.demo.repository.ComidaRepository;
import com.example.demo.utils.RandomUtil;

@Service
public class ComidaService {

	private static final List<String> NOMES_COMIDA = Arrays.asList("banana","maca","feijoada","strogonofe","feijao","macarrao","arroz","salada","pizza","hamburguer","bife a cavalo","ovo","salsicha","salpicao","quinoa","tomate","pepino","torta salgada","salgadinho","francesa","mexicana","arabe","esfiha","cochinha","empada","kibe","batata frita","churrasco","linguica","carne");
	 
	Random random = new Random();
	
	@Autowired
	private ComidaRepository comidaRepository;
	
	public Comida salvar(Comida comida) {
		return comidaRepository.save(comida);
	}
	
	public ComidaResponse post(ComidaPersist comidaPersist) {
		Comida c = salvar(comidaPersist.convertComida());
		return c.convert();
	}

	public void criarComidas(int qtdComidas) {
		while(qtdComidas > 0) {
			Comida c = new Comida(obterNomeComidaAleatorio(), Cor.obterCorAleatoria(), LocalDate.now());
			salvar(c);
			qtdComidas--;
		}
	}
	
	private String obterNomeComidaAleatorio() {
		return NOMES_COMIDA.get(RandomUtil.getNumberAleatory(NOMES_COMIDA.size()));
	}
	
	public Iterable<Comida> listar() {

		return comidaRepository.findAll();
	}
	
	public List<ComidaResponse> listarResponse() {
		
		List<ComidaResponse> retorno = new ArrayList<ComidaResponse>();
		listar().forEach(c -> retorno.add(c.convert()));
		
		return retorno;
	}
	
}
