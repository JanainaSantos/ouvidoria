package com.googlecode.ouvidoria.util.numero;

import java.math.BigDecimal;

public class Matematica {
	
	//############################################
	//Metodos de comparacao entre numeros. 	
	//
	public static int compara(BigDecimal a, BigDecimal b){
		//System.out.println("compara("+a+", "+b+")");
		return a.compareTo(b);		
	}	
	public static boolean maiorQue(BigDecimal a, BigDecimal b){
		return compara(a,b) > 0;
	}	
	public static boolean maiorQue(BigDecimal a, double b){
		return maiorQue(a,new BigDecimal(b));
	}
	public static boolean maiorQue(BigDecimal a, int b){
		return maiorQue(a,new BigDecimal(b));
	}
	public static boolean menorQue(BigDecimal a, BigDecimal b){
		return compara(a,b) < 0;
	}
	public static boolean menorQue(BigDecimal a, double b){
		return menorQue(a,new BigDecimal(b));
	}
	public static boolean menorQue(BigDecimal a, int b){
		return menorQue(a,new BigDecimal(b));
	}
	public static boolean igual(BigDecimal a, BigDecimal b){
		return compara(a,b) == 0;
	}
	public static boolean igual(BigDecimal a, double b){
		return igual(a,new BigDecimal(b));
	}
	public static boolean igual(BigDecimal a, int b){
		return igual(a,new BigDecimal(b));
	}
	public static boolean maiorOuIgual(BigDecimal a, BigDecimal b){
		return maiorQue(a,b) || igual(a,b);
	}
	public static boolean maiorOuIgual(BigDecimal a, double b){
		return maiorOuIgual(a,new BigDecimal(b));
	}
	public static boolean maiorOuIgual(BigDecimal a, int b){
		return maiorOuIgual(a,new BigDecimal(b));
	}
	public static boolean menorOuIgual(BigDecimal a, BigDecimal b){
		return menorQue(a,b) || igual(a,b);
	}	
	public static boolean menorOuIgual(BigDecimal a, double b){
		return menorOuIgual(a,new BigDecimal(b));
	}	
	public static boolean menorOuIgual(BigDecimal a, int b){
		return menorOuIgual(a,new BigDecimal(b));
	}	
	
	
	//############################################
	//Metodos para operacoes com os numeros
	//
	public static BigDecimal soma(BigDecimal a, BigDecimal b){
		return a.add(b);
	}	
	public static BigDecimal subtrai(BigDecimal a, BigDecimal b){
		return a.subtract(b);
	}
	public static BigDecimal multiplica(BigDecimal a, BigDecimal b){
		return a.multiply(b);
	}
	public static BigDecimal divide(BigDecimal a, BigDecimal b){
		return a.divide(b);
	}
	
}
