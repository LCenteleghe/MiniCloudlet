package br.unisinos.edu.request.processor;

import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.request.dto.ServiceCheckRequest;

public final class ServiceCheckRequestProcessor implements RequestProcessor<ServiceCheckRequest,  Boolean>{
	
	private ServiceCheckRequestProcessor(){}
	
	public static ServiceCheckRequestProcessor getInstance(){
		return new ServiceCheckRequestProcessor();
	}

	public Boolean processRequest(ServiceCheckRequest request){
		String serviceID = request.getServiceID();
		return ServicesBase.getInstance().contains(serviceID);
	}
}
