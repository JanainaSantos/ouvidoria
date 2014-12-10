package com.googlecode.ouvidoria.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ByteArrayUtils {
	/**
	 * Transforma o objeto passado como paramtero em um array de bytes
	 * 
	 * @param obj
	 *            objeto a ser transformado
	 * @return o array de bytes representando o objeto
	 * @throws IOException
	 */
	public static byte[] toByteArray(Object obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream outputToString = new ObjectOutputStream(baos);
		outputToString.writeObject(obj);
		outputToString.close();
		return baos.toByteArray();
	}

	/**
	 * Transforma o array de bytes em um objeto
	 * 
	 * @param array
	 *            array a ser transformado em objeto
	 * @return O Objeto gerado
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object toObject(byte[] array) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(array);
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}

	/**
	 * Concatena dois arrays de bytes
	 * 
	 * @param l
	 *            o array da esquerda
	 * @param r
	 *            o array da direita
	 * @return o array contendo os dois arrays de entrada concatenados
	 */
	public static byte[] concatenate(byte[] l, byte[] r) {
		byte[] b = new byte[l.length + r.length];
		System.arraycopy(l, 0, b, 0, l.length);
		System.arraycopy(r, 0, b, l.length, r.length);
		return b;
	}
}
