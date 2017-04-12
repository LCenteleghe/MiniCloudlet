package br.unisinos.edu.service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.unisinos.edu.Service;
import br.unisinos.edu.exception.ServiceExecutionFailureException;

public class ScriptExecutor implements ServiceExecutor {
	ScriptEngine engine;
	
	protected ScriptExecutor(){}
	
	public ScriptExecutor(String mimeType) {
		engine = new ScriptEngineManager().getEngineByMimeType(mimeType);
	}

	public Object execute(Service service, Object parametersData) {
		try {
			engine.eval(service.getCode().toString());
			Invocable invocableEngine = (Invocable) engine;
			return invocableEngine.invokeFunction(service.getEntryMethod(), parametersData);
		} catch (NoSuchMethodException | ScriptException e) {
			return new ServiceExecutionFailureException(e);
		}
	}



}
