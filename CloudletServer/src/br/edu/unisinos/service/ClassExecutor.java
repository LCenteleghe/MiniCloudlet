package br.edu.unisinos.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import br.edu.unisinos.lcloudlet.api.Service;

public class ClassExecutor implements ServiceExecutor {
	private Map<Service, Class<?>> loadedServiceClasses = new HashMap<>();

	protected ClassExecutor() {
	}

	@Override
	public Object execute(Service service, String method, Object[] parameters) {

		if (!loadedServiceClasses.containsKey(service)) {
			ByteClassLoader byteClassLoader = new ByteClassLoader();
			loadedServiceClasses.put(service, byteClassLoader.defineClass((byte[]) service.getSourceCode()));
		}

		return execute(loadedServiceClasses.get(service), method, parameters);
	}

	private Object execute(Class<?> clazz, String methodName, Object[] parameters) {
		try {
			Object instance = clazz.newInstance();
			Method method = clazz.getMethod(methodName, getTypes(parameters));
			return method.invoke(instance, parameters);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			return e;
		}
	}
	
	private Class<?>[] getTypes(Object[] parameters){
		Class<?>[] types = new Class<?>[parameters.length];
		
		for (int i = 0; i < parameters.length; i++) {
			types[i] = parameters[i].getClass();
		}
		
		return types;
	}

}
