package br.unisinos.edu.service;

import br.edu.unisinos.lcloudlet.api.Service;
import br.unisinos.edu.exception.NoServiceExecutorFound;

public final class ServiceExecutorFactory {
	private ServiceExecutorFactory(){}
	
	public static ServiceExecutor getExecutorByServiceMIME(Service service){
		String mimeType = service.getMimeType();
		
		if("application/java".equals(mimeType)){
			return new ClassExecutor();
		}
		
		if("application/javascript".equals(mimeType)){
			return new ScriptExecutor(mimeType);
		}
		
		throw new NoServiceExecutorFound(mimeType);
	}
}
