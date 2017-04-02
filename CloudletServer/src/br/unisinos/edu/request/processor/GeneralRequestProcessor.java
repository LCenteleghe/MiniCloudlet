package br.unisinos.edu.request.processor;

import br.unisinos.edu.exception.NoRequestProcessorFound;
import br.unisinos.edu.request.dto.RegistrationRequest;
import br.unisinos.edu.request.dto.ServiceCheckRequest;
import br.unisinos.edu.request.dto.ServiceExecutionRequest;

public final class GeneralRequestProcessor implements RequestProcessor<Object, Object>{
	
	/* (non-Javadoc)
	 * @see br.unisinos.edu.request.processor.RequestProcessor#processRequest(java.lang.Object)
	 */
	public Object processRequest(Object request){
		if(request instanceof RegistrationRequest){
			RegistrationRequest registrationRequest = (RegistrationRequest)request;
			return ServiceRegistrationRequestProcessor.getInstance().processRequest(registrationRequest);
		}
		
		if(request instanceof ServiceCheckRequest){
			ServiceCheckRequest serviceCheckRequest = (ServiceCheckRequest)request;
			return ServiceCheckRequestProcessor.getInstance().processRequest(serviceCheckRequest);
		}
		
		if(request instanceof ServiceExecutionRequestProcessor){
			ServiceExecutionRequest serviceExecutionRequest = (ServiceExecutionRequest)request;
			return ServiceExecutionRequestProcessor.getInstance().processRequest(serviceExecutionRequest);
		}
		
		throw new NoRequestProcessorFound(request);
	}
}
