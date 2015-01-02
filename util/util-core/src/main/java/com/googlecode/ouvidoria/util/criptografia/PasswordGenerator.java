package com.googlecode.ouvidoria.util.criptografia;

import java.util.Random;

public final class PasswordGenerator {
	private static final String LETTERS = "acdefghjkmpqrsuxyz";
	private static final String ALGARISMS = "123456789";
	private static final int DEFAULT_LENGTH = 5;

	public static String generatePassword(){
		return generatePassword(DEFAULT_LENGTH);
	}
	
	public static String generatePassword(int length){
		StringBuilder sb = new StringBuilder();
		if(length >= 0){
			for(int i=0; i < length; i++){
				sb.append(generateChar());
			}
		}
		return sb.toString();
	}
	
	private static char generateChar() {
		char newChar = '.';
		Random random = new Random();
		
		boolean isLetter = random.nextBoolean();
		if (isLetter) {
			int idx = random.nextInt(LETTERS.length());
			boolean isUpperCase = random.nextBoolean();
			if (isUpperCase) {
				newChar = LETTERS.toUpperCase().charAt(idx);
			} else {
				newChar = LETTERS.charAt(idx);
			}
		} else {
			int idx = random.nextInt(ALGARISMS.length());
			newChar = ALGARISMS.charAt(idx);
		}
		return newChar;
	}

	
	public static void main(String[] args) {
		System.out.println("generating ...");
		for(int i=0; i < 50; i++){
			System.out.println(PasswordGenerator.generatePassword());
		}
		System.out.println("done!");
	}
}
