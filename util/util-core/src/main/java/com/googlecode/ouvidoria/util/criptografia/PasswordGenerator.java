package com.googlecode.ouvidoria.util.criptografia;

import java.util.Random;

public final class PasswordGenerator {
	private static final String LETTERS = "acdefghjkmpqrsuxyz";
	private static final String ALGARISMS = "0123456789";
	private static final int DEFAULT_LENGTH = 5;

	public static String generatePassword(){
		return generatePassword(DEFAULT_LENGTH);
	}
	
	public static String generatePassword(int length){
		String password = "";
		if(length >= 0){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i < length; i++){
				sb.append(generateChar());
			}
		}
		return password;
	}
	
	private static char generateChar() {
		char newChar = '.';
		Random random = new Random(System.currentTimeMillis());

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

}
