package br.unisinos.edu.request.processor;

import br.unisinos.edu.exception.NoRequestProcessorFound;
import br.unisinos.edu.request.dto.ServiceRegistrationRequest;
import br.unisinos.edu.request.dto.ServiceCheckRequest;
import br.unisinos.edu.request.dto.ServiceExecutionRequest;

public final class GeneralRequestProcessor implements RequestProcessor<Object, Object>{
	private static GeneralRequestProcessor instance = new GeneralRequestProcessor();
	
	private GeneralRequestProcessor(){}
	
	/* (non-Javadoc)
	 * @see br.unisinos.edu.request.processor.RequestProcessor#processRequest(java.lang.Object)
	 */
	public Object processRequest(Object request){
		if(request instanceof ServiceRegistrationRequest){
			ServiceRegistrationRequest registrationRequest = (ServiceRegistrationRequest)request;
			return ServiceRegistrationRequestProcessor.getInstance().processRequest(registrationRequest);
		}
		
		if(request instanceof ServiceCheckRequest){
			ServiceCheckRequest serviceCheckRequest = (ServiceCheckRequest)request;
			return ServiceCheckRequestProcessor.getInstance().processRequest(serviceCheckRequest);
		}
		
		if(request instanceof ServiceExecutionRequest){
			ServiceExecutionRequest serviceExecutionRequest = (ServiceExecutionRequest)request;
			return ServiceExecutionRequestProcessor.getInstance().processRequest(serviceExecutionRequest);
		}
		
		throw new NoRequestProcessorFound(request);
	}
	
	public static GeneralRequestProcessor getInstance(){
		return instance;
	}
}
