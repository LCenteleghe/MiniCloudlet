package br.edu.unisinos.request.processor;

import br.edu.unisinos.ServicesDataBase;
import br.edu.unisinos.exception.ServiceNotFoundException;
import br.edu.unisinos.lcloudlet.api.Service;
import br.edu.unisinos.lcloudlet.api.ServiceExecutionRequest;
import br.edu.unisinos.service.ServiceExecutor;
import br.edu.unisinos.service.ServiceExecutorFactory;

/**
 * A service execution processor.
 */
public final class ServiceExecutionRequestProcessor implements RequestProcessor<ServiceExecutionRequest, Object> {
	private ServiceExecutionRequestProcessor() {}

	/**
	 * Gets the single instance of ServiceExecutionRequestProcessor.
	 *
	 * @return single instance of ServiceExecutionRequestProcessor
	 */
	public static ServiceExecutionRequestProcessor getInstance() {
		return new ServiceExecutionRequestProcessor();
	}

	@Override
	public Object processRequest(ServiceExecutionRequest request) {
		Service service = ServicesDataBase.getInstance().getService(request.getServiceID());
		
		if(service == null){
			throw new ServiceNotFoundException(request.getServiceID());
		}
		
		ServiceExecutor serviceExecutor = ServiceExecutorFactory.getExecutorByServiceMIME(service);
		return serviceExecutor.execute(service, request.getMethod(), request.getParametersData());
	}
}
