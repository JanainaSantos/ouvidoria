package com.googlecode.ouvidoria.util;

/**
 * Classe utilitaria com metodos estaticos para a 
 * geracao de Strings.
 * 
 */
public class StringUtils {

    /**
     * Gera um codigo concatenando zeros a esquerda de um 
     * valor inteiro.  
     * 
     * Ex.: concatenaZeros(39, 4) retorna a string "0039"
     * 
     * @param valor Valor a ter zeros concatenados a esquerda
     * @param comprimento Comprimento final da String
     */
    public static String concatenaZeros(int valor, int comprimento) {
       String codigo = "" + valor;
       
       int quantidadeZeros = comprimento - codigo.length();
       
       for(int i = 0; i < quantidadeZeros; i++) {
           codigo = "0" + codigo; 
       }
       return codigo;
    }
    
    /**
     * Gera um codigo concatenando zeros a esquerda de um 
     * valor inteiro.  
     * 
     * Ex.: concatenaZeros(39, 4) retorna a string "0039"
     * 
     * @param valor Valor a ter zeros concatenados a esquerda
     * @param comprimento Comprimento final da String
     */
    public static String concatenaZeros(String valor, int comprimento) {
              
    	if (!isStringVazia(valor)) {
    		int quantidadeZeros = comprimento - valor.length();
	       	if (quantidadeZeros < 0 ) {
	       		valor = valor.substring(valor.length() - comprimento);
			}else {
				for(int i = 0; i < quantidadeZeros; i++) {
					valor = "0" + valor; 
				}
			}
		}
    	return valor;
    }
    
	/**
	 * Verifica se a string é nula ou seu conteúdo é vazio.
	 *
	 * @param <b>str
	 *            </b> String a ser verificada
	 * @return <code>true</code> caso a string for vazia
	 */
	public static boolean isStringVazia(String str)
	{
		if (str == null)
		{
			return true;
		}

		if ((str != null) && (str.trim().length() == 0))
		{
			return true;
		}

		return false;
	}
	
	/**
	 * Converte uma String para int, removendo todos os caracteres que nao sejam
	 * digitos numericos. Ideal para remocao de pontos,hifens e parenteses de
	 * telefones, CPFs, CNPJs...
	 *
	 * @param str String a ser convertida para inteiro
	 *
	 * @return Apenas os digitos da String passada como parametro
	 */
	public static int unformat(String str)
	{
		return Integer.parseInt(unformatString(str).trim());
	}

	/**
	 * Converte uma String para outra String, removendo todos os caracteres que
	 * nao sejam digitos numericos. Ideal para remocao de pontos,hifens e
	 * parenteses de telefones, CPFs, CNPJs...
	 *
	 * @param str String a ser convertida para inteiro
	 *
	 * @return Apenas os digitos da String passada como parametro
	 */
	public static String unformatString(String str)
	{
		char[] inteiro = new char[16];
		char[] string = str.toCharArray();

		for (int i = 0, j = 0; i < string.length; i++)
		{
			if (Character.isDigit(string[i]))
			{
				inteiro[j++] = string[i];
			}
		}

		return new String(inteiro).trim();
	}
	
	
	/**
	 * Aplica a mascara de milhar em um numero inforamdo. 
	 * Ex: 123456789 ira retornar 123.456.789
	 * 
	 * Detalhe, se for informado um numero com zeros a esquerda, 
	 * esta funcao chama o metodo removeZerosEsquerda, retornando apenas a
	 * parte do numero sem os zeros. 
	 * Ex: 0003456789 ira retornar 3.456.789
	 * 
	 * @param numero
	 * @return {@link String}
	 */
	public static String poeMascaraMilhar(String numero) {
		numero = removeZerosEsquerda(numero);
		String numeroComMascaraMilhar = "";
		int ct = 0;
		
		for (int i = numero.trim().length()-1; i >= 0; i--) {
			ct++;
			numeroComMascaraMilhar = numero.charAt(i) + numeroComMascaraMilhar;
			if(ct == 3 && i != 0) {
				numeroComMascaraMilhar = "." + numeroComMascaraMilhar;
				ct = 0;
			}
		}
		
		return numeroComMascaraMilhar;
	}
	
	/** 
	 * Remove os zeros a esquerda de uma valor informado. 
	 * Ex: 000123456 ira retornar 123456.
	 * @param valor
	 * @return {@link String} sem zeros a esquerda.
	 */
	public static String removeZerosEsquerda(String valor) {
		valor = valor.trim();
		
		for (int i = 0; i < valor.length(); i++) {
			if(valor.charAt(i) == '0') {
				continue;
			}
			return valor.substring(i);
		}
		return valor;
	}
	
	public static String removeUltimoChar(String str, String ch){
		return str.substring(0, str.lastIndexOf(ch)).trim();		
	}
	
	public static String toString(Object obj){
		return toString(obj, false);
	}
	
	public static String toString(Object obj, boolean simples){
		if(obj == null)
			return "{null}";
		return "";//TODO org.apache.commons.lang.builder.ReflectionToStringBuilder.toString(obj, (simples)?org.apache.commons.lang.builder.ToStringStyle.SIMPLE_STYLE:org.apache.commons.lang.builder.ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
