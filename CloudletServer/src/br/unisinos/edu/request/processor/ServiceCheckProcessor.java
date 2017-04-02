package br.unisinos.edu.request.processor;

import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.request.dto.ServiceCheckRequest;

public final class ServiceCheckProcessor implements RequestProcessor<ServiceCheckRequest,  Boolean>{
	
	private ServiceCheckProcessor(){}
	
	public static ServiceCheckProcessor getInstance(){
		return new ServiceCheckProcessor();
	}

	public Boolean processRequest(ServiceCheckRequest request){
		String serviceID = request.getServiceID();
		return ServicesBase.getInstance().contains(serviceID);
	}
}
