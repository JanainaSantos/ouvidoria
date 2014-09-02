package com.googlecode.ouvidoria.util.numero;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.googlecode.ouvidoria.util.StringUtils;

public class BigDecimalUtil {
	
	
	/**
	 * @param valorStr
	 * @return
	 */
	public static BigDecimal parser(String valorStr) {
		
		if (StringUtils.isStringVazia(valorStr)) {
			return null;
		}
		
		try
		{
			return new BigDecimal(valorStr.replaceAll("\\.", "").replace(',', '.'));
			
		} catch (Exception e)
		{
			throw new RuntimeException("N\u00FAmero em um formato inv\u00E1lido[" + valorStr + "]");
		}
	}
	
	/**
	 * @param valor
	 * @param maximoDecimais
	 * @param minimoDecimais
	 * @return
	 */
	public static String formata(BigDecimal valor) {
		
		return formata(valor, null, null, null, null);
	}
	/**
	 * @param valor
	 * @param maximoDecimais
	 * @param minimoDecimais
	 * @return
	 */
	public static String formata(BigDecimal valor,Integer maximoDecimais, Integer minimoDecimais) {
		
		return formata(valor, null, null, maximoDecimais, minimoDecimais);
	}
	/**
	 * @param valor
	 * @param maximoInteiro
	 * @param minimoInteiro
	 * @param maximoDecimais
	 * @param minimoDecimais
	 * @return
	 */
	public static String formata(BigDecimal valor,Integer maximoInteiro,Integer minimoInteiro,Integer maximoDecimais, Integer minimoDecimais) {
		
		if (valor == null) {
			return null;
		}
		
		try
		{
			// Set the default locale to custom locale
			Locale.setDefault(new Locale("pt", "BR"));
			
			DecimalFormat decimalFormat = new DecimalFormat();
			if (maximoInteiro!=null) {
				decimalFormat.setMaximumIntegerDigits(maximoInteiro);
			}
			if (minimoInteiro!=null) {
				decimalFormat.setMinimumIntegerDigits(minimoInteiro);
			}
			//Casas decimiais
			if (maximoDecimais!=null) {
				decimalFormat.setMaximumFractionDigits(maximoDecimais);
			}
			if (minimoDecimais!=null) {
				decimalFormat.setMinimumFractionDigits(minimoDecimais);
			}
			
			return decimalFormat.format(valor);
			
		} catch (Exception e)
		{
			throw new RuntimeException("N\u00FAmero em um formato inv\u00E1lido[" + valor + "]");
		}
	}
	
	 /**
	 * @param s
	 * @return
	 */
	public static boolean isNumeric( String s ) {  
		 if (s !=null) {
			 // cria um array de char  
			 char[] c = s.toCharArray();  
			 
			 for ( int i = 0; i < c.length; i++ )  {
				 // verifica se o char não é um dígito  
				 if ( !Character.isDigit( c[ i ] ) ) {  
					 return false;  
				 }  
			 }  
		}
	     return true;  
	 }
	
	private static final Locale BRAZIL = new Locale("pt","BR");
	private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
	public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("###,###,##0.00",REAL);
	
	public static String mascaraDinheiro(BigDecimal valor){    
 		return DINHEIRO_REAL.format(valor);    
	}

}
