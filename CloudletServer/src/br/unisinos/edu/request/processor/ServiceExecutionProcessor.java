package br.unisinos.edu.request.processor;

import java.util.WeakHashMap;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.unisinos.edu.Service;
import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.request.dto.ServiceExecutionRequest;

public final class ServiceExecutionProcessor implements RequestProcessor<ServiceExecutionRequest, Object> {
	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");


	private ServiceExecutionProcessor() {
	}

	public static ServiceExecutionProcessor getInstance() {
		return new ServiceExecutionProcessor();
	}

	public Object processRequest(ServiceExecutionRequest request) {
		Service service = ServicesBase.getInstance().getService(request.getServiceID());

		try {
			engine.eval(service.getCode());
			Invocable invocableEngine = (Invocable) engine;
			return invocableEngine.invokeFunction(service.getEntryMethod(), request.getParameterData());
		} catch (NoSuchMethodException | ScriptException e) {
			return e;
		}
	}
}
