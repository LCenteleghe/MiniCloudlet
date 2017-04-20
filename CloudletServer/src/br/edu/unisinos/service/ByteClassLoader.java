package br.edu.unisinos.service;

/**
 * A class loader used to load a class based on its bytes.
 */
public class ByteClassLoader extends ClassLoader {
	
	/**
	 * Defines and resolve a class based in its bytes.
	 *
	 * @param classBytes the class bytes
	 * @return the defined class
	 */
	public Class<?> defineClass(byte[] classBytes) {
		return defineClass(null, classBytes);
	}
	
	/**
	/**
	 * Defines and resolve a class based in its bytes.
	 * 
	 * @param className 
	 * @param classBytes the class bytes
	 * @return the defined class
	 */
	public Class<?> defineClass(String className, byte[] classBytes) {
		Class<?> clazz = defineClass(null, classBytes, 0, classBytes.length);
		resolveClass(clazz);

		return clazz;
	}

	/**
	 * Gets the class given its name.
	 *
	 * @param className the class name
	 * @return the class, or null if not found.
	 */
	public Class<?> getClass(String className) {
		return findLoadedClass(className);
	}
}