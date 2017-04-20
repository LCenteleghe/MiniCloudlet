package br.edu.unisinos.request.processor;

import br.edu.unisinos.exception.NoRequestProcessorFound;
import br.edu.unisinos.lcloudlet.api.ServiceExecutionRequest;
import br.edu.unisinos.lcloudlet.api.ServiceRegistrationRequest;
import br.edu.unisinos.lcloudlet.api.SimpleQueryRequest;

/**
 * A general query processor. Used as an entry point for any request.
 */
public final class GeneralRequestProcessor implements RequestProcessor<Object, Object>{
	private static GeneralRequestProcessor instance = new GeneralRequestProcessor();
	
	private GeneralRequestProcessor(){}
	
	@Override
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
	
	/**
	 * Gets the single instance of GeneralRequestProcessor.
	 *
	 * @return single instance of GeneralRequestProcessor
	 */
	public static GeneralRequestProcessor getInstance(){
		return instance;
	}
}
