package br.unisinos.edu.service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.edu.unisinos.lcloudlet.api.Service;
import br.unisinos.edu.exception.ServiceExecutionFailureException;

public class ScriptExecutor implements ServiceExecutor {
	ScriptEngine engine;
	
	protected ScriptExecutor(){}
	
	public ScriptExecutor(String mimeType) {
		engine = new ScriptEngineManager().getEngineByMimeType(mimeType);
	}

	public Object execute(Service service, Object[] parameters) {
		try {
			engine.eval(service.getSourceCode().toString());
			Invocable invocableEngine = (Invocable) engine;
			return invocableEngine.invokeFunction(service.getEntryMethod(), parameters);
		} catch (NoSuchMethodException | ScriptException e) {
			return new ServiceExecutionFailureException(e);
		}
	}
}
