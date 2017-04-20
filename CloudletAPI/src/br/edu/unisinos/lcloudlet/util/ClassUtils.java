package br.edu.unisinos.lcloudlet.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class utilities.
 */
public class ClassUtils {
	
	/**
	 * Gets the bytes of a class.
	 *
	 * @param clazz the clazz
	 * @return the class bytes
	 */
	public static byte[] getClassBytes(Class<?> clazz){
		String className = clazz.getName();
		String classAsPath = className.replace('.', '/') + ".class";
		InputStream is = clazz.getClassLoader().getResourceAsStream(classAsPath);
		
		return readAllBytes(is);
	}

	/**
	 * Read all bytes from a input stream.
	 *
	 * @param stream the input stream
	 * @return the byte[]
	 */
	private static byte[] readAllBytes(InputStream stream) {
		ByteArrayOutputStream classBytes = new ByteArrayOutputStream();

		byte[] buffer = new byte[16384];
		int nRead;
		try {
			while ((nRead = stream.read(buffer, 0, buffer.length)) != -1) {
			  classBytes.write(buffer, 0, nRead);
			}
			classBytes.flush();
			return classBytes.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
