package br.unisinos.edu.service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.unisinos.edu.Service;

public class ClassExecutor implements ServiceExecutor {
	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");
	
	protected ClassExecutor(){}
	
	@Override
	public Object execute(Service service, Object parametersData) {
		try {
			engine.eval(service.getCode().toString());
			Invocable invocableEngine = (Invocable) engine;
			return invocableEngine.invokeFunction(service.getEntryMethod(), parametersData);
		} catch (NoSuchMethodException | ScriptException e) {
			return e;
		}
	}

}
