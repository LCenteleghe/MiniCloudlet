package br.unisinos.edu.request.processor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import br.unisinos.edu.Service;
import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.request.dto.RegistrationRequest;
import br.unisinos.edu.request.dto.ServiceExecutionRequest;

public final class ServiceExecutionProcessor implements RequestProcessor<ServiceExecutionRequest<?>, Boolean> {
	ScriptEngineManager factory = new ScriptEngineManager();
	ScriptEngine engine = factory.getEngineByName("JavaScript");

	private ServiceExecutionProcessor() {
	}

	public static ServiceExecutionProcessor getInstance() {
		return new ServiceExecutionProcessor();
	}

	public Boolean processRequest(ServiceExecutionRequest<?> request) {
		return ServicesBase.getInstance().registerService(service);
	}
}
