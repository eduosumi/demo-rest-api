package com.example.demo.enums;

import java.util.Arrays;
import java.util.List;

import com.example.demo.utils.RandomUtil;

public enum Cor {

	VERDE, VERMELHO, AMARELO, ROSA, AZUL;

	public static final List<Cor> CORES = Arrays.asList(Cor.values());

	public static Cor obterCorAleatoria() {
		return CORES.get(RandomUtil.getNumberAleatory(CORES.size()));
	}
}
