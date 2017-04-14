package br.unisinos.edu.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import br.unisinos.edu.Service;

public class ClassExecutor implements ServiceExecutor {
	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");
	
	protected ClassExecutor(){}
	
	@Override
	public Object execute(Service service, Object parametersData) {
		try {
			Class<?> clazz = (Class<?>)service.getCode();
			Object instance = clazz.newInstance();
			Method method = clazz.getMethod(service.getEntryMethod());
			return method.invoke(instance, parametersData);
		} catch (InstantiationException | 
				IllegalAccessException | 
				IllegalArgumentException | 
				InvocationTargetException |
				NoSuchMethodException | 
				SecurityException e) {
			return e;
		}
	}

}
