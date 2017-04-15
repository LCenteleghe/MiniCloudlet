package br.unisinos.edu.request.processor;

import br.edu.unisinos.lcloudlet.api.ServiceExecutionRequest;
import br.edu.unisinos.lcloudlet.api.ServiceRegistrationRequest;
import br.edu.unisinos.lcloudlet.api.SimpleQueryRequest;
import br.unisinos.edu.exception.NoRequestProcessorFound;

public final class GeneralRequestProcessor implements RequestProcessor<Object, Object>{
	private static GeneralRequestProcessor instance = new GeneralRequestProcessor();
	
	private GeneralRequestProcessor(){}
	
	/* (non-Javadoc)
	 * @see br.unisinos.edu.request.processor.RequestProcessor#processRequest(java.lang.Object)
	 */
	public Object processRequest(Object request){
		if(request instanceof SimpleQueryRequest){
			SimpleQueryRequest serviceCheckRequest = (SimpleQueryRequest)request;
			return SimpleQueryRequestProcessor.getInstance().processRequest(serviceCheckRequest);
		}
		
		if(request instanceof ServiceRegistrationRequest){
			ServiceRegistrationRequest registrationRequest = (ServiceRegistrationRequest)request;
			return ServiceRegistrationRequestProcessor.getInstance().processRequest(registrationRequest);
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
