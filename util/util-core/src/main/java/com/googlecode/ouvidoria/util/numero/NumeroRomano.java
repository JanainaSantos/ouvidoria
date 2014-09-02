package com.googlecode.ouvidoria.util.numero;

//LIMITACAO: converte apenas entre 1 e 3999, pois existem os s�mbolos para continuar: http://pt.wikipedia.org/wiki/Numera%C3%A7%C3%A3o_romana
public class NumeroRomano {
	private static int[] NUMEROS = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static String[] LETRAS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	
	public static String toRomano(int numero) {
		if (numero < 1)
            throw new NumberFormatException("O n\u00FAmero deve ser positivo. Valor informado: "+numero);
         if (numero > 3999)
            throw new NumberFormatException("O n\u00FAmero deve ser 3999 ou menor. Valor informado: "+numero);
         
	     String romano = ""; 
	     for (int i = 0; i < NUMEROS.length; i++) {
	        while (numero >= NUMEROS[i]) {
	           romano += LETRAS[i];
	           numero -= NUMEROS[i];
	        }
	     }
	     
	     return romano;
	}

	public static int toArabico(String romano){
		//boolean isRomanNumeral = true;

		// Constructor.  Creates the Roman number with the given representation.
		// For example, RomanNumeral("xvii") is 17.  If the parameter is not a
		// legal Roman numeral, a NumberFormatException is thrown.  Both upper and
		// lower case letters are allowed.
		 
		if (romano.length() == 0) {
			//isRomanNumeral = false;
			throw new NumberFormatException("Uma string vazia n\u00E3o define um numeral romano.");
			
			//TODO retornar 0 (zero)?
		}
		 
		romano = romano.toUpperCase();  // Convert to upper case letters.
	  
		int i = 0;  // A position in the string, roman;
		int arabic = 0; // Arabic numeral equivalent of the part of the string that has
						// been converted so far.
	  
		while (i < romano.length()) {

			char letter = romano.charAt(i);    // Letter at current position in string.
			int number = letterToNumber(letter);  // Numerical equivalent of letter.
		 
			if (number < 0) {
				//isRomanNumeral = false;
				throw new NumberFormatException("Caracter ilegal \"" + letter + "\" no numeral romano.");
			}
			
			i++;  // Move on to next position in the string
		 
			if (i == romano.length()) {
				// There is no letter in the string following the one we have just processed.
				// So just add the number corresponding to the single letter to arabic.
				arabic += number;
			 } else {
				// Look at the next letter in the string.  If it has a larger Roman numeral
				// equivalent than number, then the two letters are counted together as
				// a Roman numeral with value (nextNumber - number).
				int nextNumber = letterToNumber(romano.charAt(i));
				if (nextNumber > number) {
					// Combine the two letters to get one value, and move on to next position in string.
					arabic += (nextNumber - number);
					i++;
				} else {
					// Don't combine the letters.  Just add the value of the one letter onto the number.
					arabic += number;
				}
			}
		}
	  
		if (arabic > 3999) {
			throw new NumberFormatException("O numeral romano deve ter valor 3999 ou menos.");
			//isRomanNumeral = false;
		}		 	
	  
		return arabic;
	}	

	private static int letterToNumber(char letter) {
		// Find the integer value of letter considered as a Roman numeral.  Return
		// -1 if letter is not a legal Roman numeral.  The letter must be upper case.
		switch (letter) {
			case 'I':  return 1;
			case 'V':  return 5;
			case 'X':  return 10;
			case 'L':  return 50;
			case 'C':  return 100;
			case 'D':  return 500;
			case 'M':  return 1000;
			default: return -1;
		}
	}
	
	public static void main(String[] args){		
		String tmp = NumeroRomano.toRomano(3947);
		System.out.println("3947="+tmp+" --- "+NumeroRomano.toArabico(tmp));
		System.out.println("5="+NumeroRomano.toRomano(5)+"\t--- "+NumeroRomano.toArabico(NumeroRomano.toRomano(5)));
		System.out.println("4="+NumeroRomano.toRomano(4)+"\t--- "+NumeroRomano.toArabico(NumeroRomano.toRomano(4)));
		System.out.println("3="+NumeroRomano.toRomano(3)+"\t--- "+NumeroRomano.toArabico(NumeroRomano.toRomano(3)));
		System.out.println("9="+NumeroRomano.toRomano(9)+"\t--- "+NumeroRomano.toArabico(NumeroRomano.toRomano(9)));
		//System.out.println("0="+NumeroRomano.toRomano(0));
		//System.out.println("4000="+NumeroRomano.toRomano(4000));
	}
	
}
