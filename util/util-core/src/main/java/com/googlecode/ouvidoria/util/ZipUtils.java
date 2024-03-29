package com.googlecode.ouvidoria.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**Classe utilitaria usada para zipar/dezipar objetos
 * @author pedro
 *
 */
public class ZipUtils {
	
	
	/**Zipa o objeto passado como parametro
	 * @param obj objeto a ser zipado
	 * @return array de bytes representando o objeto zipado
	 * @throws IOException 
	 */
	public static byte[] zipar(Object obj) throws IOException {	
		byte[] input = ByteArrayUtils.toByteArray(obj);
	    // Create the compressor with highest level of compression
	    Deflater compressor = new Deflater();
	    compressor.setLevel(Deflater.BEST_COMPRESSION);
	    
	    // Give the compressor the data to compress
	    compressor.setInput(input);
	    compressor.finish();
	    
	    // Create an expandable byte array to hold the compressed data.
	    // You cannot use an array that's the same size as the orginal because
	    // there is no guarantee that the compressed data will be smaller than
	    // the uncompressed data.
	    ByteArrayOutputStream bos = new ByteArrayOutputStream(input.length);
	    
	    // Compress the data
	    byte[] buf = new byte[1024];
	    while (!compressor.finished()) {
	        int count = compressor.deflate(buf);
	        bos.write(buf, 0, count);
	    }
	    try {
	        bos.close();
	    } catch (IOException e) {
	    }
	    
	    // Get the compressed data
	    byte[] compressedData = bos.toByteArray();
	    return compressedData;
	}
	
	
	/**Dezipa os bytes zipados
	 * @param compressedData dados zipados
	 * @return o array de bytes dezipados
	 */
	public static byte[] dezipar(byte[] compressedData){
//		 Create the decompressor and give it the data to compress
	    Inflater decompressor = new Inflater();
	    decompressor.setInput(compressedData);
	    
	    // Create an expandable byte array to hold the decompressed data
	    ByteArrayOutputStream bos = new ByteArrayOutputStream(compressedData.length);
	    
	    // Decompress the data
	    byte[] buf = new byte[1024];
	    while (!decompressor.finished()) {
	        try {
	            int count = decompressor.inflate(buf);
	            bos.write(buf, 0, count);
	        } catch (DataFormatException e) {
	        }
	    }
	    try {
	        bos.close();
	    } catch (IOException e) {
	    }
	    
	    // Get the decompressed data
	    byte[] decompressedData = bos.toByteArray();
	    return decompressedData;
	}
}
