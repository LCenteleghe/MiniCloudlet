package br.unisinos.edu.request.processor;

import br.edu.unisinos.lcloudlet.api.Service;
import br.edu.unisinos.lcloudlet.api.ServiceExecutionRequest;
import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.service.ServiceExecutor;
import br.unisinos.edu.service.ServiceExecutorFactory;

public final class ServiceExecutionRequestProcessor implements RequestProcessor<ServiceExecutionRequest, Object> {



	private ServiceExecutionRequestProcessor() {
	}

	public static ServiceExecutionRequestProcessor getInstance() {
		return new ServiceExecutionRequestProcessor();
	}

	public Object processRequest(ServiceExecutionRequest request) {
		Service service = ServicesBase.getInstance().getService(request.getServiceID());
		ServiceExecutor serviceExecutor = ServiceExecutorFactory.getExecutorByServiceMIME(service);
		return serviceExecutor.execute(service, request.getParametersData());
	}
}
