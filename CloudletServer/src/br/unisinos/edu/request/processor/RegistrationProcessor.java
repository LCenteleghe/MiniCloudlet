package br.unisinos.edu.request.processor;

import br.unisinos.edu.Service;
import br.unisinos.edu.ServicesBase;
import br.unisinos.edu.request.dto.RegistrationRequest;

public final class RegistrationProcessor implements RequestProcessor<RegistrationRequest,  Boolean>{
	
	private RegistrationProcessor(){}
	
	public Boolean processRequest(RegistrationRequest request){
		Service service = request.getService();
		return ServicesBase.getInstance().registerService(service);
	}
	
	public static RegistrationProcessor getInstance(){
		return new RegistrationProcessor();
	}
}

