package com.googlecode.ouvidoria.util;


/**
 * Classe utilitaria usada para validar CNPJ e CPF
 * 
 * @author pedro
 * 
 */
public class ValidacaoUtils {
	
	//TODO remover essa classe e usar do UTIL
	

	// EX: 02998301000181 -- CNPJ valido
	/**
	 * Valida o CNPJ passado como parametro
	 * 
	 * @param str_cnpj
	 *            representacao do CNPJ. Apenas os numeros
	 * @return true se o CNPJ for valido e false caso contrario
	 * @throws Exception
	 *             lanca excecao no caso de entrada invalida ou erro de processamento
	 */
	static public boolean CNPJ(String str_cnpj) throws Exception {
		int soma = 0, dig;
		String cnpj_calc = str_cnpj.substring(0, 12);

		if (str_cnpj.length() != 14)
			return false;

		char[] chr_cnpj = str_cnpj.toCharArray();

		/* Primeira parte */
		for (int i = 0; i < 4; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
				soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);

		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		/* Segunda parte */
		soma = 0;
		for (int i = 0; i < 5; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
				soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		boolean cond = str_cnpj.equals(cnpj_calc);
		//log.info("Validar CNPJ: " + str_cnpj + ". Valido: " + cond);
		return cond;
	}

	/**
	 * Valida o CPF passado como parametro
	 * 
	 * @param strCpf
	 *            representacao do CPF. Apenas os numeros
	 * @return true se o CPF for valido e false caso contrario
	 */
	static public boolean CPF(String strCpf) {
		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}

		// Primeiro resto da divisao por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito eh 0 caso contrario o digito eh 11 menos o resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divisao por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito eh 0 caso contrario o digito eh 11 menos o resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que esta sendo validado.
		String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
		boolean cond = nDigVerific.equals(nDigResult);
		//log.info("Validar CPF: " + strCpf + ". Valido: " + cond);
		return cond;
	}

}
