package com.example.demo.utils;

import java.util.Random;

public class RandomUtil {

	public static final Random RANDOM = new Random();
	
	public static int getNumberAleatory(int bound) {
		return RANDOM.nextInt(bound);
	}
	
}
