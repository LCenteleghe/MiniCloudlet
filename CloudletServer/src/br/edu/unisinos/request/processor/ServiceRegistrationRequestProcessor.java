package br.edu.unisinos.request.processor;

import br.edu.unisinos.ServicesDataBase;
import br.edu.unisinos.lcloudlet.api.Service;
import br.edu.unisinos.lcloudlet.api.ServiceRegistrationRequest;

/**
 * A service registration processor.
 */
public final class ServiceRegistrationRequestProcessor implements RequestProcessor<ServiceRegistrationRequest,  Boolean>{
	
	private ServiceRegistrationRequestProcessor(){}
	
	public Boolean processRequest(ServiceRegistrationRequest request){
		Service service = request.getService();
		return ServicesDataBase.getInstance().registerService(service);
	}
	
	/**
	 * Gets the single instance of ServiceRegistrationRequestProcessor.
	 *
	 * @return single instance of ServiceRegistrationRequestProcessor
	 */
	public static ServiceRegistrationRequestProcessor getInstance(){
		return new ServiceRegistrationRequestProcessor();
	}
}

