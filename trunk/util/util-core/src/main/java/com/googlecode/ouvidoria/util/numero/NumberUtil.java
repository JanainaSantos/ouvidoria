package com.googlecode.ouvidoria.util.numero;

/**
 * Classe que manipula numerais.
 * 
 * @author 
 *
 */
public final class NumberUtil {
    
    /**
     * Verifica se o valor passado eh um numero infinito ou nao e um numero(NaN - Not a Number)
     *  
     * @param number Valor do numero a ser verificado.
     * 
     * @return 0, se se o valor eh um numero infinito ou nao eh um numero, e o proprio valor, se caso contrario.
     */
    public static Double checkInfinityOrNaN(Double number) {
        if (number.isInfinite() || number.isNaN()) {
            return 0.0;
        } else {
            return number;
        }
    }
    
	/**
	 * Retorna a parte fracionaria de um Double.
	 * 
	 * @param valor Valor nao-inteiro do numero fracionario.
	 * 
	 * @return Valor da parte fracionaria.
	 */
	public static Double getParteFracionaria(Double valor) {
		return (valor % 1);
	}

}
