package br.edu.unisinos.request.processor;

import br.edu.unisinos.ServicesBase;
import br.edu.unisinos.lcloudlet.api.Service;
import br.edu.unisinos.lcloudlet.api.ServiceRegistrationRequest;

public final class ServiceRegistrationRequestProcessor implements RequestProcessor<ServiceRegistrationRequest,  Boolean>{
	
	private ServiceRegistrationRequestProcessor(){}
	
	public Boolean processRequest(ServiceRegistrationRequest request){
		Service service = request.getService();
		return ServicesBase.getInstance().registerService(service);
	}
	
	public static ServiceRegistrationRequestProcessor getInstance(){
		return new ServiceRegistrationRequestProcessor();
	}
}

