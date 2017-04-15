package br.edu.unisinos.service;

public class ByteClassLoader extends ClassLoader {
	public Class<?> defineClass(byte[] classBytes) {
		return defineClass(null, classBytes);
	}
	
	public Class<?> defineClass(String className, byte[] classBytes) {
		Class<?> clazz = defineClass(null, classBytes, 0, classBytes.length);
		resolveClass(clazz);

		return clazz;
	}

	public Class<?> getClass(String className) {
		return findLoadedClass(className);
	}
}