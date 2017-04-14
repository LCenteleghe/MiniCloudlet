package br.unisinos.edu.request.processor;

import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.lcloudlet.api.Service;
import br.unisinos.edu.lcloudlet.api.ServiceRegistrationRequest;

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

