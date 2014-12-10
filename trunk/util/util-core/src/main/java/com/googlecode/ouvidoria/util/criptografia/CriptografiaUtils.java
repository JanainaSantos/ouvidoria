package com.googlecode.ouvidoria.util.criptografia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitaria para criptografia
 * 
 * @author pedro
 *
 */
public class CriptografiaUtils {

	public static String md5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			byte[] enc = md.digest();
			String md5Sum = new String(Base64Coder.encode(enc));
			return md5Sum;
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println(nsae.getMessage());
			return null;
		}
	}
	
	public static void main(String[] args) {
		//ICy5YqxZB1uWSwcVLSNLcA==
		String input = "123";
		System.out.println(CriptografiaUtils.md5(input));
	}
}
